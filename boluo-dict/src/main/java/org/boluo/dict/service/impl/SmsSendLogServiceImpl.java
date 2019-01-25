package org.boluo.dict.service.impl;


import org.boluo.dict.dao.SmsSendLogDao;
import org.boluo.dict.model.SmsSendLog;
import org.boluo.dict.service.SmsSendLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.service.mybatis.impl.ServiceImpl;


@Service("smsSendLogService")
public class SmsSendLogServiceImpl extends ServiceImpl<SmsSendLogDao,SmsSendLog,Integer> implements SmsSendLogService{
	@Autowired
	public void setDao(SmsSendLogDao dao) {
		this.dao = dao;
		
	}


}
