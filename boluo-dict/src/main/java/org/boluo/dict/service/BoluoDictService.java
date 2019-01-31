package org.boluo.dict.service;


import org.boluo.dict.model.BoluoDict;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.Service;

public interface BoluoDictService extends Service<BoluoDict,Integer>{
	/*public Pagination<BoluoDict> findPagination(String dictCode,String dictDesc,Integer isEnabel,Pagination<BoluoDict> p);*/
	
	public Pagination<BoluoDict> findPagination(Dto dto,Pagination<BoluoDict> p);
	
	public BoluoDict findByDictCode(String dictCode,Integer dictId);
	
	
}