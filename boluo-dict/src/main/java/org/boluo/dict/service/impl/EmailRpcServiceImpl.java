package org.boluo.dict.service.impl;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.boluo.utils.rpc.notice.EmailRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.util.StringUtils;
import com.sun.mail.util.MailSSLSocketFactory;
import com.xxl.conf.core.XxlConfClient;

@Service("emailRpcService")
public class EmailRpcServiceImpl implements EmailRpcService{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 配置中心项目名称
	 */
	private String appCode = ConfigUtils.getProperty("app_code");
	
	private final String MAIL_HOST = "smtp.exmail.qq.com";
	private final String MAIL_PROTOCOL = "SMTP";
	private final int MAIL_PORT = 465;
	 
	private final String emailMark=XxlConfClient.get(appCode + ".email.mark");
	private final String fromAddr = XxlConfClient.get(appCode + ".email.from.addr"); // 发件人的email
	private final String fromPwd = XxlConfClient.get(appCode + ".email.from.pwd"); // 发件人密码
	
	private final ThreadLocal<Integer> threadNum = new ThreadLocal<Integer>();
	
	/**
	 * 获取Session
	 * 
	 * @return
	 * @throws GeneralSecurityException
	 */
	private  Session getSession() throws GeneralSecurityException {
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		Properties pro = new Properties();
		pro.put("mail.smtp.host", MAIL_HOST);
		pro.put("mail.smtp.port", MAIL_PORT);
		pro.put("mail.store.protocol", MAIL_PROTOCOL);
		pro.put("mail.smtp.auth", true);
		pro.put("mail.smtp.ssl.enable", true);
		pro.put("mail.smtp.ssl.socketFactory", sf);
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromAddr, fromPwd);
			}
		};
		Session session = Session.getDefaultInstance(pro, authenticator);
		return session;
	}

	@Override
	public void sendEmail(String title, List<String> toEmails, String content, List<String> copyEmails) {
		/*判断邮件开关是否关闭*/
		if("0".equals(emailMark)) {
			logger.info("邮件功能已屏蔽!");
			return ;
    	}
		try {
			
			delRepeatEmail(toEmails,copyEmails);
			
			StringBuffer info=new StringBuffer("【EmailSendInfo】start:");
			info.append("邮件的主题:"+title);
			info.append(",收件人的邮箱:"+convertData(toEmails));
			if(!CollectionUtils.isEmpty(copyEmails)) {
				info.append(",抄送人邮件:"+convertData(copyEmails));
			}
			
			logger.info(info.toString());
			
			Session session = getSession();
			Message msg = new MimeMessage(session);
			// Set message attributes
			msg.setFrom(new InternetAddress(fromAddr));
			
			List<InternetAddress> toEmailList = new ArrayList<InternetAddress>();
			for (String email : toEmails) {
				if(StringUtils.isNotBlank(email)) {
					toEmailList.add(new InternetAddress(email));
				}
			}
			InternetAddress[] toemailArray = new InternetAddress[toEmailList.size()];
			msg.setRecipients(Message.RecipientType.TO, toEmailList.toArray(toemailArray));

			msg.setSubject(title);
			msg.setSentDate(new Date());
			msg.setContent(content, "text/html;charset=utf-8");
			
			if(!CollectionUtils.isEmpty(copyEmails)) {
				List<InternetAddress> copyEmailList = new ArrayList<>();
				for (String email : copyEmails) {
					if(StringUtils.isNotBlank(email)) {
						copyEmailList.add(new InternetAddress(email));
					}
				}
				InternetAddress[] emailArray = new InternetAddress[copyEmailList.size()];
				msg.setRecipients(Message.RecipientType.CC, copyEmailList.toArray(emailArray));
			}
			// Send the message
			Transport.send(msg);
			
		} catch(SendFailedException e) {
			logger.info("【EmailSendInfo】异常="+e.getMessage());
			repeatEmail(title,toEmails,content,copyEmails,e);
		} catch (Exception e) {
			logger.info("【EmailSendInfo】异常="+e.getMessage());
		}
		
	}
	
	/**
	 * 发送失败重发一次
	 * @param title
	 * @param content
	 * @param e
	 */
	private  void repeatEmail(String title, List<String> toEmails, String content, List<String> copyEmails,SendFailedException e) {
		Address[] invalidAddr = e.getInvalidAddresses(); //得到无效效但未能成功将消息发送到的地址
		Integer num = threadNum.get();
		if(null==invalidAddr && num!=null){
			logger.info("【EmailSendInfo】重发异常="+e.getMessage());
		}
		threadNum.set(1);
		//去掉无效地址的邮件
		StringBuffer invalidEmail=new StringBuffer();
		for(int i=0;i<invalidAddr.length;i++) {
			String email = invalidAddr[i].toString();
			invalidEmail.append(email+",");
			if(!CollectionUtils.isEmpty(toEmails)&&toEmails.contains(email)) {
				toEmails.remove(email);
			}
			if(!CollectionUtils.isEmpty(copyEmails)&&copyEmails.contains(email)) {
				copyEmails.remove(email);
			}
		}
		logger.info("【EmailSendInfo】无效地址="+invalidEmail.toString());
		
		//判断是否全部为无效地址
		if(CollectionUtils.isEmpty(toEmails) && CollectionUtils.isEmpty(copyEmails)) {
			logger.info("【EmailSendInfo】异常：收件人与发件人列表均是无效地址！");
			return;
		}
		sendEmail (title, toEmails,  content, copyEmails);
	}

	private String convertData(List<String> emails) {
		StringBuffer buffer=new StringBuffer();
		String retStr=null;
		if(!CollectionUtils.isEmpty(emails)) {
			for(String email:emails) {
				buffer.append(email+",");
			}
			if(buffer.length()>1) {
				retStr=buffer.substring(0, buffer.length()-1);
			}
		}
		return retStr;
	}
	
	/**
	 * 收件人与抄送人去重，若是抄送人已经在发件人列表中则移除
	 * @param toEmails
	 * @param copyEmails
	 * @return
	 */
	private void delRepeatEmail(List<String> toEmails,List<String> copyEmails) {
		List<String> copyEmailsTemp=new ArrayList<String>(copyEmails);
		logger.info("【EmailSendInfo】抄送邮箱去重before:"+convertData(copyEmailsTemp));
		if(CollectionUtils.isEmpty(toEmails)) {
			return;
		}
		if(CollectionUtils.isEmpty(copyEmails)) {
			return;
		}
		for(String copyEmail:copyEmailsTemp) {
			if(toEmails.contains(copyEmail)) {
				copyEmails.remove(copyEmail);
			}
		}
		logger.info("【EmailSendInfo】抄送邮箱去重after:"+convertData(copyEmails));
	}
}
