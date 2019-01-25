package org.boluo.utils.rpc.syslog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 记录信息:</br>
 * 访问时间</br>
 * Controller路径</br>
 * 对应方法名</br>
 * 请求参数信息</br>
 * 请求相对路径</br>
 * 请求处理时长
 * 
 * @author Administrator
 * 
 */
public abstract class TimeCostInterceptorBase implements HandlerInterceptor {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}
	
	protected abstract StringBuilder addUserAccount(HttpServletRequest request,StringBuilder logInfo);

}
