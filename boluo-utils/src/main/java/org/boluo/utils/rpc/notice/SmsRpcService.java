package org.boluo.utils.rpc.notice;

import java.util.Map;

public interface SmsRpcService {
	
	 /**
     * 如果是给多个号码发送 参数tel传手机号码拼接的字符串，用逗号隔开
     * @param tel
     * @param textTemplate 模板code
     * @param param 模板参数，没有传null
     * @param signName 签名，可空
     * @param createUserId 创建人，可空
     * @return
     */
	public Map<String,String> sendSms(String tel,String templateCode,String param,String signName,Integer createUserId);
	
	/**
	 * 根据手机号查询某个业务发送的次数
	 * @param bizId
	 * @param tel
	 * @return
	 */
	public  Integer qrySendResult(String bizId,String tel);

}
