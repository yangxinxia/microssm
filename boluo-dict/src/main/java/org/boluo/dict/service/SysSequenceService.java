package org.boluo.dict.service;


import org.boluo.dict.model.SysSequence;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.Service;

public interface SysSequenceService extends Service<SysSequence,Integer>{
	public Pagination<SysSequence> findPagination(Dto params, Pagination<SysSequence> p);
	
	public Integer qryNextVal(String seqName);
	
	public SysSequence findBySeqName(String seqName,Integer seqId);
}