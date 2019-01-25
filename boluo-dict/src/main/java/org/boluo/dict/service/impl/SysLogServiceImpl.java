package org.boluo.dict.service.impl;


import org.boluo.dict.dao.SysLogDao;
import org.boluo.dict.model.SysLog;
import org.boluo.dict.service.SysLogService;
import org.boluo.utils.wrapper.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.impl.ServiceImpl;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao,SysLog,Integer> implements SysLogService{
	@Autowired
	public void setDao(SysLogDao dao) {
		this.dao = dao;
		
	}

	@Override
	public Pagination<SysLog> findPagination(Dto params, Pagination<SysLog> p) {
		dao.findPagination(params,p);
		return p;
	}
	
}
