package org.boluo.dict.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.boluo.dict.common.BaseController;
import org.boluo.dict.model.SysLog;
import org.boluo.dict.service.SysLogService;
import org.boluo.utils.wrapper.Dto;
import org.boluo.utils.wrapper.Dtos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.model.Result;


@Controller
public class SysLogController extends BaseController{
	
	@Resource
	private SysLogService sysLogService;
	
	@RequestMapping(value = "/sysLogList", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result sysLogList(HttpServletRequest request) {
		Result result=this.createSuccessResult();
		Dto inDto = Dtos.newDto(request);
		Integer pageNo=inDto.getInteger("pageNo");
		if(pageNo==null) {
			pageNo=1;
		}
		Integer pageSize=inDto.getInteger("pageSize");
		if(pageSize==null) {
			pageSize=20;
		}
		Pagination<SysLog> p=new Pagination<SysLog>(pageNo, pageSize);
		Pagination<SysLog> retData=sysLogService.findPagination(inDto, p);
		return result.setData(retData);
	}
	
	
}
