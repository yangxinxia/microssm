package org.boluo.demo.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.boluo.demo.common.BaseController;
import org.boluo.demo.common.RedisCache;
import org.boluo.demo.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Result;
import com.smart.sso.rpc.UserRpcDto;
import com.smart.sso.rpc.UserRpcService;
@Controller
public class TestController extends BaseController{
	@Autowired
	private  UserRpcService userRpcService;
	
	@Autowired
	private  DemoTestService demoTestService;
	
	@Resource
	private RedisCache<String> redisCache;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result  logout(HttpServletRequest request,HttpServletResponse response) {
		Result result=this.createSuccessResult();
		//String[] roleBusiCodes=new String[] {"sourcedirector","sourcemanage"};
		//List<UserRpcDto> dataList=userRpcService.findUsersByRoleBusiCode(roleBusiCodes, 7,"杨",true);
		/*String ids="6,7,8,9";
		List<Integer> idArr=StringUtils.getAjaxIds(ids);
		List<UserRpcDto> dataList=userRpcService.findUsersByUserIds(idArr);*/
		//result.setData(dataList);
		//demoTestService.demoTestService();
		
		//redis 的用法 start
		redisCache.set("yangxinxia", "yangxinxiayangxinxiayangxinxia");
		System.err.println("redisCacheredisCache="+redisCache.get("yangxinxia"));
		//redis 的用法 end
		return result;
	}
	
	
}
