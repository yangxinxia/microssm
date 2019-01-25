package org.boluo.dict.service;

import java.util.List;

import org.boluo.dict.model.BoluoDictItem;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.service.mybatis.Service;

public interface BoluoDictItemService extends Service<BoluoDictItem, Integer> {
	public List<BoluoDictItem> findByDictCode(Dto dto);
}
