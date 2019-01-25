package org.boluo.dict.service.impl;


import java.util.Date;

import javax.annotation.Resource;

import org.boluo.dict.model.SysLog;
import org.boluo.dict.service.SysLogService;
import org.boluo.utils.rpc.syslog.SysLogRpcService;
import org.boluo.utils.rpc.syslog.SysRpcLog;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * @author yangxinxia
 * @Description 记录日志的aop，先使用pointcut expression定义一个切面
 * @Date Created on  2019-01-14
 */
@Service("sysLogRpcService")
public class SysLogRpcServiceImpl implements SysLogRpcService {
    
	@Resource
	private SysLogService sysLogService;
   
	@Override
	public void addSysLog(SysRpcLog sysRpcLog) {
		SysLog sysLog=new SysLog();
		BeanUtils.copyProperties(sysRpcLog,sysLog);
		sysLog.setCreateTime(new Date());
		sysLogService.save(sysLog);
	}

}
