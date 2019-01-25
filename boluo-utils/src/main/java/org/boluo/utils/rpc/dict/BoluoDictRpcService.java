package org.boluo.utils.rpc.dict;

import java.util.List;



public interface BoluoDictRpcService {
	public RpcDict findBoluoDict(String dictCode);
	public List<RpcDictItem> findBoluoDictItem(String dictCode);
	public RpcDictItem findBoluoDictItem(String dictCode,String dictItemCode);
	
	public Integer qryNextVal(String seqName);
}
