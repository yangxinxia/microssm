package org.boluo.utils.rpc.notice;

import java.util.List;

public interface EmailRpcService {
	
	/**
	 * 发送邮件
	 * @param title 邮件标题
	 * @param toEmails 收件人列表
	 * @param content 邮件内容
	 * @param copyEmails 邮件抄送人列表
	 */
	public void sendEmail(String title, List<String> toEmails, String content, List<String> copyEmails);
	
}
