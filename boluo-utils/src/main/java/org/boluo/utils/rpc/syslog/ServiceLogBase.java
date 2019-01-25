package org.boluo.utils.rpc.syslog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceLogBase {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected SysLogRpcService sysLogRpcService; 
	
	/**
	 * 定义切面，使用注解Servicelog注解的方法都会被拦截
	 */
	@Pointcut("@annotation(org.boluo.utils.rpc.syslog.Servicelog)")
	public void cutService() {

	}
	
	public abstract Object around(ProceedingJoinPoint point)throws Throwable;
}
