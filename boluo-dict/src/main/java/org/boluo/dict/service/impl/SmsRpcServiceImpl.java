package org.boluo.dict.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.boluo.dict.model.SmsSendLog;
import org.boluo.dict.service.SmsSendLogService;
import org.boluo.utils.rpc.notice.SmsRpcService;
import org.boluo.utils.wrapper.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.util.StringUtils;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;
import com.xxl.conf.core.XxlConfClient;

@Service("smsRpcService")
public class SmsRpcServiceImpl implements SmsRpcService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SmsSendLogService smsSendLogService;
	/**
	 * 配置中心项目名称
	 */
	protected String appCode = ConfigUtils.getProperty("app_code");

	private final String product = "Dysmsapi";
	// 产品域名,开发者无需替换
	private final String domain = "dysmsapi.aliyuncs.com";

	private final String accessKeyId = XxlConfClient.get(appCode + ".sms.accesskeyid");
	private final String accessKeySecret = XxlConfClient.get(appCode + ".sms.accesskeysecret");
	private final String smsMark = XxlConfClient.get(appCode + ".sms.mark");
	private final String signName="菠萝在线";

	@Override
	public Map<String,String> sendSms(String tel, String templateCode, String param, String signName,Integer createUserId) {
		Map<String,String> retMap=new HashMap<String,String>();
		SmsSendLog smsSendLog =new SmsSendLog();
		smsSendLog.setCreateTime(new Date());
		smsSendLog.setTel(tel);
		smsSendLog.setParam(param);
		smsSendLog.setTemplateCode(templateCode);
		smsSendLog.setCreateBy(createUserId);
		/* 判断短信功能是否可用 */
		if ("0".equals(smsMark)) {
			logger.info("短信功能已屏蔽！");
			retMap.put("code", "OK");
			retMap.put("message","短信功能已屏蔽！");
			return retMap;
		}
		try {
			
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");

			// 初始化acsClient,暂不支持region化
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
			IAcsClient acsClient = new DefaultAcsClient(profile);

			// 组装请求对象-具体描述见控制台-文档部分内容
			SendSmsRequest smsRequest = new SendSmsRequest();
			// 必填:待发送手机号
			smsRequest.setPhoneNumbers(tel);
			// 必填:短信签名
			if(StringUtils.isBlank(signName)) {
				signName=this.signName;
			}
			smsRequest.setSignName(signName);
			// 必填:短信模板
			smsRequest.setTemplateCode(templateCode);

			if (!StringUtils.isBlank(param)) {
				smsRequest.setTemplateParam(param);
			}
			// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
			// request.setSmsUpExtendCode("90997");

			// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
			smsRequest.setOutId("yourOutId");

			SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(smsRequest);
			
			retMap.put("code", sendSmsResponse.getCode());
			retMap.put("message",sendSmsResponse.getMessage());
			retMap.put("bizId", sendSmsResponse.getBizId());
			
			StringBuffer bf=new StringBuffer();
			bf.append("tel:" + tel);
			bf.append(",templateCode:" + templateCode);
			bf.append(",code:" + sendSmsResponse.getCode());
			bf.append(",param:"+ param);
			bf.append(", msg：" + sendSmsResponse.getMessage());
			bf.append(",bizid:" + sendSmsResponse.getBizId());
			
			logger.info("【smsSend】result="+bf.toString());
			
			/**
			 * 保存日志
			 */

			smsSendLog.setBizid(sendSmsResponse.getBizId());
			smsSendLog.setReceiveCode(sendSmsResponse.getCode());
			smsSendLogService.save(smsSendLog);
			
		} catch (ClientException e) {
			logger.error("【smsSend】ClientException异常"+e.getMessage());
			smsSendLog.setExceptionMsg("ClientException="+e.getMessage());
			smsSendLogService.save(smsSendLog);
		} catch (Exception e) {
			logger.error("【smsSend】Exception异常"+e.getMessage());
			smsSendLog.setExceptionMsg("Exception="+e.getMessage());
			smsSendLogService.save(smsSendLog);
			e.printStackTrace();
		}
		return retMap;
	}

	@Override
	public Integer qrySendResult(String bizId, String tel) {
		Integer totalCnt=0;
		QuerySendDetailsResponse querySendDetailsResponse = null;
		try {
			// 可自助调整超时时间
			System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
			System.setProperty("sun.net.client.defaultReadTimeout", "10000");

			// 初始化acsClient,暂不支持region化
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);

			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

			IAcsClient acsClient = new DefaultAcsClient(profile);

			// 组装请求对象
			QuerySendDetailsRequest request = new QuerySendDetailsRequest();
			// 必填-号码
			request.setPhoneNumber(tel);
			// 可选-流水号
			request.setBizId(bizId);
			// 必填-发送日期 支持30天内记录查询，格式yyyyMMdd
			SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
			request.setSendDate(ft.format(new Date()));
			// 必填-页大小
			request.setPageSize(10L);
			// 必填-当前页码从1开始计数
			request.setCurrentPage(1L);

			querySendDetailsResponse = acsClient.getAcsResponse(request);
			
			totalCnt=Integer.valueOf(querySendDetailsResponse.getTotalCount());

		} catch (ClientException e) {
			logger.error("【smsSendQuery】异常："+e.getMessage());
			//e.printStackTrace();
		}
		return totalCnt;
	}

}
