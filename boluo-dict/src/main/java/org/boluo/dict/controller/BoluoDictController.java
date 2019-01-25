package org.boluo.dict.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.boluo.dict.common.BaseController;
import org.boluo.dict.model.BoluoDict;
import org.boluo.dict.model.BoluoDictItem;
import org.boluo.dict.service.BoluoDictItemService;
import org.boluo.dict.service.BoluoDictService;
import org.boluo.utils.wrapper.Dto;
import org.boluo.utils.wrapper.Dtos;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.model.Result;


@Controller
public class BoluoDictController extends BaseController{
	
	@Resource
	private BoluoDictService boluoDictService;
	
	@Resource
	private BoluoDictItemService boluoDictItemService;
	
	/*@RequestMapping(value = "/boluoDict", method = RequestMethod.GET)
	public  @ResponseBody Result boluoDictGet(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNo,
			@RequestParam(required = false, defaultValue = "20") int pageSize,
			String dictCode,
			String dictDesc,
			@RequestParam(required = false, defaultValue = "1") int isEnabel) {
		Result result=this.createSuccessResult();
		
		Pagination<BoluoDict> p=new Pagination<BoluoDict>(pageNo, pageSize);
		List<BoluoDict> retData=boluoDictService.findPagination(dictCode,dictDesc,isEnabel, p);
		return result.setData(retData);
	}*/
	
	@RequestMapping(value = "/boluoDict", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result boluoDictList(HttpServletRequest request) {
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
		Pagination<BoluoDict> p=new Pagination<BoluoDict>(pageNo, pageSize);
		Pagination<BoluoDict> retData=boluoDictService.findPagination(inDto, p);
		return result.setData(retData);
	}
	
	@RequestMapping(value = "/boluoDict/Save", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result boluoDictSave(HttpServletRequest request,@RequestBody BoluoDict boluoDict) {
		Result result=this.createSuccessResult();
		if(boluoDict.getId()==null) {
			boluoDict.setCreateTime(new Date());
		}
		else {
			boluoDict.setUpdateTime(new Date());
		}
		boluoDictService.save(boluoDict);
		return result;
	}
	
	@RequestMapping(value = "/boluoDictItem/Save", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public  @ResponseBody Result boluoDictSave(HttpServletRequest request,@RequestBody BoluoDictItem boluoDictItem) {
		Result result=this.createSuccessResult();
		if(boluoDictItem.getId()==null) {
			boluoDictItem.setCreateTime(new Date());
		}
		else {
			boluoDictItem.setUpdateTime(new Date());
		}
		boluoDictItemService.save(boluoDictItem);
		return result;
	}
	
	@RequestMapping(value = "/boluoDict/ValidCode", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result boluoDictValidCode(HttpServletRequest request,
		   @RequestParam(required = true) String dictCode,
		   @RequestParam(required = false) Integer dictId) {
		Result result=this.createSuccessResult();
		
		BoluoDict boluoDict=boluoDictService.findByDictCode(dictCode,dictId);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		if(boluoDict!=null) {
			resultMap.put("isRepeat", true);
		}
		else {
			resultMap.put("isRepeat", false);
		}
		return result.setData(resultMap);
	}
	
	@RequestMapping(value = "/boluoDictItem", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result boluoDictItem(HttpServletRequest request) {
		Result result=this.createSuccessResult();
		Dto inDto = Dtos.newDto(request);
		List<BoluoDictItem> retData=boluoDictItemService.findByDictCode(inDto);
		return result.setData(retData);
	}
	
	@RequestMapping(value = "/boluoDictItem/ValidCode", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody Result boluoDictItemValidCode(HttpServletRequest request,
		   @RequestParam(required = true) String dictCode,
		   @RequestParam(required = true) String dictitemCode,
		   @RequestParam(required = false) Integer dictitemId) {
		Result result=this.createSuccessResult();
		Dto inDto = Dtos.newDto();
		inDto.put("dictCode", dictCode);
		inDto.put("dictitemCode", dictitemCode);
		inDto.put("dictitemId", dictitemId);
		List<BoluoDictItem> dictItemList=boluoDictItemService.findByDictCode(inDto);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		if(!CollectionUtils.isEmpty(dictItemList)) {
			resultMap.put("isRepeat", true);
		}
		else {
			resultMap.put("isRepeat", false);
		}
		return result.setData(resultMap);
	}
}
