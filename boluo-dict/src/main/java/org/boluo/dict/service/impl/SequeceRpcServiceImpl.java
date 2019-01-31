package org.boluo.dict.service.impl;

import javax.annotation.Resource;

import org.boluo.dict.service.SysSequenceService;
import org.boluo.utils.rpc.sequence.SequenceRpcService;
import org.springframework.stereotype.Service;


@Service("sequenceRpcService")
public class SequeceRpcServiceImpl implements SequenceRpcService{
	
	@Resource
	private SysSequenceService sysSequenceService;

	@Override
	public Integer qryNextVal(String seqName) {
		return sysSequenceService.qryNextVal(seqName);
	}

}
