package org.boluo.dict.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.boluo.dict.common.BaseController;
import org.boluo.dict.service.SysSequenceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Result;
import com.smart.sso.client.SessionPermission;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;
import com.xxl.conf.core.XxlConfClient;

@Controller
public class IndexController extends BaseController{
	@Resource 
	private SysSequenceService sysSequenceService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String  index(HttpServletRequest request,HttpServletResponse response) {
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		String token=sessionUser.getToken();
		Integer userId=sessionUser.getUserId();
		String sessionId=request.getSession().getId();
		String url = XxlConfClient.get(appCode+".redirect.url", "");
		String param="?userId="+userId+"&token="+token+"&SESSION="+sessionId;
		return "redirect:"+url+param;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result  logout(HttpServletRequest request,HttpServletResponse response) {
		Result result=this.createSuccessResult();
		result.setMessage("登出成功");
		Map<String,Object> urlMap=new HashMap<String,Object>();
		String ssoLoginUrl=getLocalUrl(request)+"/index";
		urlMap.put("loginUrl", ssoLoginUrl);
		result.setData(urlMap);
		return result;
	}
	
	@RequestMapping(value = "/function", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result function(HttpServletRequest request) {
		
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		// 登录用户名
		String userName=sessionUser.getAccount();
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		String manageUserIds=sessionUser.getManageUserIds();
		String busiCodes=sessionUser.getRoleBusiCode();
		
		
		Map<String,Object> userInfoMap=new HashMap<String,Object>();
		
		userInfoMap.put("userName", userName);
		userInfoMap.put("sessionPermission", sessionPermission);
		userInfoMap.put("manageUserIds", manageUserIds);
		userInfoMap.put("busiCodes", busiCodes);
		
		Result result=this.createSuccessResult();
		
		// 如果配置的权限拦截器，则获取登录用户权限下的菜单，没有权限拦截限制的情况下，获取当前系统菜单呈现
		return result.setData(userInfoMap);
	}
	
	/**
	 * 获取当前上下文路径
	 * 
	 * @param request
	 * @return
	 */
	private String getLocalUrl(HttpServletRequest request) {
		return new StringBuilder().append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort() == 80 ? "" : request.getServerPort()).append(request.getContextPath())
				.toString();
	}
	
	@RequestMapping(value = "/testJob", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result  testJob(HttpServletRequest request){
		Result result=this.createSuccessResult();
		sysSequenceService.resetInitVal();
		return result;
	}
}
