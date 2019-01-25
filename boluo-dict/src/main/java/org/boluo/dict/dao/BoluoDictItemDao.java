package org.boluo.dict.dao;

import java.util.List;

import org.boluo.dict.model.BoluoDictItem;
import org.boluo.utils.wrapper.Dto;

import com.smart.mvc.dao.mybatis.Dao;

public interface BoluoDictItemDao extends Dao<BoluoDictItem,Integer>{
   public List<BoluoDictItem> findByDictCode(Dto dto);
}