package org.boluo.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boluo.dict.model.BoluoDict;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;

public interface BoluoDictDao extends Dao<BoluoDict, Integer> {
	/*public List<BoluoDict> findPagination(@Param("dictCode") String dictCode, @Param("dictDesc") String dictDesc,
			@Param("isEnabel") Integer isEnabel, Pagination<BoluoDict> p);*/
	public List<BoluoDict> findPagination(@Param("params") Dto params, Pagination<BoluoDict> p);
	
	public BoluoDict findByDictCode(@Param("dictCode") String dictCode, @Param("dictId") Integer dictId,
			@Param("isEnabel") Integer isEnabel);
	
	public Integer qryNextVal(@Param("seqName") String seqName);

}