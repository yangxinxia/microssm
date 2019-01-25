package org.boluo.dict.syslog;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.boluo.utils.rpc.syslog.TimeCostInterceptorBase;
import org.boluo.utils.wrapper.util.DateUtils;
import org.boluo.utils.wrapper.util.RequestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;


/**
 * 记录信息:</br> 访问时间</br>Controller路径</br>对应方法名</br>请求参数信息</br>请求相对路径</br>请求处理时长
 * 
 * @author Administrator
 * 
 */
public class TimeCostInterceptor extends  TimeCostInterceptorBase {


    // before the actual handler will be executed
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        if (handler instanceof HandlerMethod) {
        	
            StringBuilder sb = new StringBuilder(1000);

            sb.append("-----------------------").append(DateUtils.format(new Date(),DateUtils.DATE_FULL_FORMAT))
                    .append("-------------------------------------\n");
            HandlerMethod h = (HandlerMethod) handler;
            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
            sb.append("Params    : ").append(RequestUtils.getParamString(request.getParameterMap())).append("\n");
            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
            //增加用户登录账号信息
            sb=addUserAccount(request,sb);
            System.out.println(sb.toString());
            logger.info(sb.toString());
        }
        return true;
    }

    // after the handler is executed
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if(handler instanceof HandlerMethod){
            StringBuilder sb = new StringBuilder(1000);
            sb.append("CostTime  : ").append(executeTime).append("ms").append("\n");
            sb.append("-------------------------------------------------------------------------------").append("\n");
            //增加用户登录账号信息
            sb=addUserAccount(request,sb);
            System.out.println(sb.toString());
            logger.info(sb.toString());
        }
    }

    /**
     * 增加用户登录账号
     * @param request
     * @param logInfo
     * @return
     */
    @Override
    protected StringBuilder addUserAccount(HttpServletRequest request,StringBuilder logInfo) {
    	SessionUser sessionUser = SessionUtils.getSessionUser(request);
    	if(sessionUser!=null) {
    		String account=sessionUser.getAccount();
    		StringBuffer accountStr=new StringBuffer("Account    : ");
    		accountStr=accountStr.append(account).append("\n");
    		logInfo.insert(0, accountStr);
    		logInfo.append(accountStr);
    	}
    	return logInfo;
    }

}