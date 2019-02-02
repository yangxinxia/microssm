package org.boluo.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.boluo.demo.service.DemoTestService;
import org.boluo.utils.constant.Module;
import org.boluo.utils.lock.CacheLock;
import org.boluo.utils.lock.LockedObject;
import org.boluo.utils.rpc.notice.EmailRpcService;
import org.boluo.utils.rpc.notice.SmsRpcService;
import org.boluo.utils.rpc.syslog.Servicelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoTestService")
public class DemoTestServiceImpl implements DemoTestService{

	@Autowired
	private  SmsRpcService smsRpcService;
	@Autowired
	private EmailRpcService emailRpcService;
	
	/*@Autowired
	private EmailRpcService emailRpcService;*/
	
	@Override
	public void demoTestService() {
		System.out.println("DemoTestServiceImpl:demoTestService");
		/*JSONObject code = new JSONObject();
		code.put("password", "123");
		code.put("salePhone", "13524943121");
		code.put("surname", "王");
		code.put("userId", "SDST20191001427");
		code.put("startDate", "2019-01-24 20:00:00");
		smsRpcService.sendSms("13524943121", "SMS_143867530", code.toJSONString(),null,2);*/
		
		 /*List<String> toEmails=new ArrayList<String>();
		 toEmails.add("yangxinxia2@boluozaixian.com");
		 toEmails.add("liushuang2@boluozaixian.com");
		 toEmails.add("jinbiao2@boluozaixian.com");
		 
		 String content="【测试邮件：这是一封测试邮件！】";
		 List<String> copyEmails=new ArrayList<String>();
		 copyEmails.add("yangxinxia2@boluozaixian.com");
		 copyEmails.add("chenjinbiao2@boluozaixian.com");
		 copyEmails.add("gaodalei2@boluozaixian.com");
		 
		 emailRpcService.sendEmail("【test】测试邮件", toEmails, content, copyEmails);*/
		
		
		
	}

	@Override
	@Servicelog(sysName=Module.Sys.DEMO,module = Module.Demo.DEMO)
	@CacheLock(lockedPrefix="test_lock")
	public void testRedisLock(String lockMethod,@LockedObject Integer pkId) {
		System.out.println("lockMethod="+lockMethod);
		System.out.println("pkId="+pkId);
	}

}
