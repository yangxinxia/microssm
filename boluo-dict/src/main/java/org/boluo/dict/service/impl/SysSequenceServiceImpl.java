package org.boluo.dict.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.boluo.dict.dao.SysSequenceDao;
import org.boluo.dict.model.SysSequence;
import org.boluo.dict.service.SysSequenceService;
import org.boluo.utils.constant.Constant;
import org.boluo.utils.rpc.dict.BoluoDictRpcService;
import org.boluo.utils.rpc.dict.RpcDictItem;
import org.boluo.utils.wrapper.Dto;
import org.boluo.utils.wrapper.util.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.impl.ServiceImpl;


@Service("sysSequenceService")
public class SysSequenceServiceImpl extends ServiceImpl<SysSequenceDao,SysSequence,Integer> implements SysSequenceService{
	
	@Resource
	private BoluoDictRpcService boluoDictRpcService;
	
	@Autowired
	public void setDao(SysSequenceDao dao) {
		this.dao = dao;
		
	}


	@Override
	public Integer qryNextVal(String seqName) {
		return dao.qryNextVal(seqName);
	}


	@Override
	public Pagination<SysSequence> findPagination(Dto params, Pagination<SysSequence> p) {
		dao.findPagination(params, p);
		List<SysSequence> dataList=(List<SysSequence>)p.getList();
		
		List<RpcDictItem> dictLoopList=boluoDictRpcService.findBoluoDictItemList("loop_frequency");
		List<RpcDictItem> dictEnabelList=boluoDictRpcService.findBoluoDictItemList("is_enabel");
		for(SysSequence seq:dataList) {
			String frequencyDesc=DictUtils.getDictItemDesc(seq.getLoopFrequency(),dictLoopList);
			seq.setLoopFrequencyDesc(frequencyDesc);
			String isEnabelDesc=DictUtils.getDictItemDesc(seq.getIsEnabel().toString(),dictEnabelList);
			seq.setIsEnabelDesc(isEnabelDesc);
		}
	
		return p;
	}


	@Override
	public SysSequence findBySeqName(String seqName, Integer seqId) {
		return dao.findBySeqName(seqName, seqId, Constant.IsEnabel.ENABEL);
	}
	
}
