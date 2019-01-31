package org.boluo.dict.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.boluo.dict.common.BaseController;
import org.boluo.dict.model.BoluoDict;
import org.boluo.dict.model.SysSequence;
import org.boluo.dict.service.SysSequenceService;
import org.boluo.utils.wrapper.Dto;
import org.boluo.utils.wrapper.Dtos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.model.Result;


@Controller
public class SysSequenceController extends BaseController{
	
	@Resource
	private SysSequenceService sysSequenceService;
	
	@RequestMapping(value = "/sysSequenceList", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result sysSequenceList(HttpServletRequest request) {
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
		Pagination<SysSequence> p=new Pagination<SysSequence>(pageNo, pageSize);
		Pagination<SysSequence> retData=sysSequenceService.findPagination(inDto, p);
		return result.setData(retData);
	}
	
	@RequestMapping(value = "/sysSequence/Save", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result sysSequenceSave(HttpServletRequest request,@RequestBody SysSequence sysSequence) {
		Result result=this.createSuccessResult();
		if(sysSequence.getId()==null) {
			sysSequence.setCreateTime(new Date());
		}
		else {
			sysSequence.setUpdateTime(new Date());
		}
		sysSequenceService.save(sysSequence);
		return result;
	}
	
	@RequestMapping(value = "/sysSequence/ValidSeqName", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result sysSequenceValidSeqName(HttpServletRequest request,
		   @RequestParam(required = true) String seqName,
		   @RequestParam(required = false) Integer seqId) {
		Result result=this.createSuccessResult();
		
		SysSequence sysSequence=sysSequenceService.findBySeqName(seqName, seqId);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		if(sysSequence!=null) {
			resultMap.put("isRepeat", true);
		}
		else {
			resultMap.put("isRepeat", false);
		}
		return result.setData(resultMap);
	}
}
