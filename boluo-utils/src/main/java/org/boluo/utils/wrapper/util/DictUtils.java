package org.boluo.utils.wrapper.util;

import java.util.List;

import org.boluo.utils.rpc.dict.RpcDictItem;


public class DictUtils {
	/**
	 * 根据字典明细代码获取描述
	 * @param dictItemCode 字典明细代码
	 * @param dictItemList 字典类型对应的明细列表
	 * @return
	 */
	public static String getDictItemDesc(String dictItemCode,List<RpcDictItem> dictItemList) {
		for(RpcDictItem dictItem:dictItemList) {
			if(dictItem.getDictitemCode().equals(dictItemCode)) {
				return dictItem.getDictitemDesc();
			}
		}
		return null;
	}
}
