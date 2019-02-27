package org.boluo.dict.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.boluo.dict.model.SysSequence;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.mvc.model.Pagination;

public interface SysSequenceDao extends Dao<SysSequence,Integer>{
	public List<SysSequence> findPagination(@Param("params") Dto params, Pagination<SysSequence> p);
	public Integer qryNextVal(@Param("seqName") String seqName);
	
	public SysSequence findBySeqName(@Param("seqName") String seqName, @Param("seqId") Integer seqId,
			@Param("isEnabel") Integer isEnabel);
	
	public int updateByLoopFrequency(@Param("loopFrequency") String loopFrequency);
}