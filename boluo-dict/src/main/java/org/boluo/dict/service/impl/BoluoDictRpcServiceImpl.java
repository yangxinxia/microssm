package org.boluo.dict.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.boluo.dict.model.BoluoDict;
import org.boluo.dict.model.BoluoDictItem;
import org.boluo.dict.service.BoluoDictItemService;
import org.boluo.dict.service.BoluoDictService;
import org.boluo.utils.constant.Constant;
import org.boluo.utils.rpc.dict.BoluoDictRpcService;
import org.boluo.utils.rpc.dict.RpcDict;
import org.boluo.utils.rpc.dict.RpcDictItem;
import org.boluo.utils.wrapper.Dto;
import org.boluo.utils.wrapper.Dtos;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


@Service("boluoDictRpcService")
public class BoluoDictRpcServiceImpl implements BoluoDictRpcService{
	
	@Resource
	private BoluoDictService boluoDictService;
	
	@Resource
	private BoluoDictItemService boluoDictItemService;

	@Override
	public RpcDict findBoluoDict(String dictCode) {
		BoluoDict boluoDict=boluoDictService.findByDictCode(dictCode,null);
		RpcDict rpcDict=new RpcDict();
		if(boluoDict!=null) {
			BeanUtils.copyProperties(boluoDict,rpcDict);
		}
		return rpcDict;
	}

	@Override
	public List<RpcDictItem> findBoluoDictItem(String dictCode) {
		Dto param=Dtos.newDto();
		param.put("dictCode", dictCode);
		param.put("isEnabel", Constant.IsEnabel.ENABEL);
		List<BoluoDictItem> dictItemList=boluoDictItemService.findByDictCode(param);
		List<RpcDictItem> rpcDictItemList=new ArrayList<RpcDictItem>();
		RpcDictItem rpcDictItem=null;
		if(!CollectionUtils.isEmpty(dictItemList)) {
			for(BoluoDictItem boluoDictItem:dictItemList) {
				rpcDictItem=new RpcDictItem();
				BeanUtils.copyProperties(boluoDictItem,rpcDictItem);
				rpcDictItemList.add(rpcDictItem);
			}
		}
		return rpcDictItemList;
	}

	@Override
	public RpcDictItem findBoluoDictItem(String dictCode, String dictItemCode) {
		Dto param=Dtos.newDto();
		param.put("dictCode", dictCode);
		param.put("dictItemCode", dictItemCode);
		param.put("isEnabel", Constant.IsEnabel.ENABEL);
		List<BoluoDictItem> dictItemList=boluoDictItemService.findByDictCode(param);
		RpcDictItem rpcDictItem=new RpcDictItem();
		if(!CollectionUtils.isEmpty(dictItemList)) {
			BoluoDictItem boluoDictItem=dictItemList.get(0);
			BeanUtils.copyProperties(boluoDictItem,rpcDictItem);
		}
		return rpcDictItem;
	}

	@Override
	public Integer qryNextVal(String seqName) {
		return boluoDictService.qryNextVal(seqName);
	}

}
