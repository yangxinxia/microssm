package org.boluo.dict.service;


import org.boluo.dict.model.SysLog;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.Service;

public interface SysLogService extends Service<SysLog,Integer>{
	public Pagination<SysLog> findPagination(Dto params, Pagination<SysLog> p);
}