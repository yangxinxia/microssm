package org.boluo.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boluo.dict.model.SysLog;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;

public interface SysLogDao extends Dao<SysLog,Integer>{
	public List<SysLog> findPagination(@Param("params") Dto params, Pagination<SysLog> p);
}