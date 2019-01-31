package org.boluo.dict.syslog;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.boluo.utils.rpc.syslog.ServiceLogBase;
import org.boluo.utils.rpc.syslog.Servicelog;
import org.boluo.utils.rpc.syslog.SysRpcLog;
import org.boluo.utils.wrapper.util.RequestUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

@Aspect
@Component
public class ServiceLogAction extends ServiceLogBase{

	 /**
     * 配置环绕通知
     * 首先获取拦截的方法对象。通过方法对象获取拦截的标注对象，获取标注参数，记录日志
     * @param point
     * @return
     */
	@Override
    @Around(value = "cutService()")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        Object object = null;
        //获取拦截的方法
        Signature sig = point.getSignature();
        if(!(sig instanceof MethodSignature)){
            throw new IllegalArgumentException("该注解只能使用在方法上！");
        }
        MethodSignature msig = (MethodSignature) sig;
        //接下来通过拦截的方法名获取使用标注的方法
        Method method = null;
        try{
            method = point.getTarget().getClass().getMethod(msig.getName(),msig.getParameterTypes());
        }catch (NoSuchMethodException e){
            logger.error(e.getMessage());
        }
        //如果拦截的方法不为空，说明有方法使用了SystemServicelog注解
        if (method!=null){
            //再次判断方法是否使用SystemServicelog注解
            if(method.isAnnotationPresent(Servicelog.class)){
                //获取方法使用的注解实例
            	Servicelog annotation = method.getAnnotation(Servicelog.class);
            	SysRpcLog sysLog = new SysRpcLog();
                sysLog.setSysName(annotation.sysName());
                sysLog.setModule(annotation.module());
                sysLog.setClassName(annotation.className());
                sysLog.setMethod(annotation.methoed());
                HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
                if(request!=null) {
               	    String requestParam=RequestUtils.getParamString(request.getParameterMap());
                    sysLog.setRequestParam(requestParam);
                    sysLog.setRequestIp(RequestUtils.getIpAddr(request));
                    SessionUser sessionUser = SessionUtils.getSessionUser(request);
                    if(sessionUser!=null) {
                    	sysLog.setUserId(sessionUser.getUserId());
                    	sysLog.setUserAccount(sessionUser.getAccount());
                    }
               }
                try {
                    object = point.proceed();
                    sysLog.setCommit("执行成功！");
                    sysLogRpcService.addSysLog(sysLog);
                }catch (Throwable e){
                	sysLog.setCommit("发生异常！");
                	sysLog.setErrMsg(e.getMessage());
                	sysLogRpcService.addSysLog(sysLog);
                }
            } else {
                object = point.proceed();
            }
        }else {
            object = point.proceed();
        }
        return object;
    }

}
