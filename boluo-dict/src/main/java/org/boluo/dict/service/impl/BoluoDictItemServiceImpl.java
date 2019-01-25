package org.boluo.dict.service.impl;

import java.util.List;

import org.boluo.dict.dao.BoluoDictItemDao;
import org.boluo.dict.model.BoluoDictItem;
import org.boluo.dict.service.BoluoDictItemService;
import org.boluo.utils.constant.Module;
import org.boluo.utils.rpc.syslog.Servicelog;
import org.boluo.utils.wrapper.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.service.mybatis.impl.ServiceImpl;

@Service("boluoDictItemService")
public class BoluoDictItemServiceImpl extends ServiceImpl<BoluoDictItemDao,BoluoDictItem,Integer> implements BoluoDictItemService {
	
	@Autowired
	public void setDao(BoluoDictItemDao dao) {
		this.dao = dao;
		
	}

	@Override
	@Servicelog(sysName=Module.Sys.DICT,module = Module.Dict.DICT, className="BoluoDictItemServiceImpl",methoed = "findByDictCode")
	public List<BoluoDictItem> findByDictCode(Dto dto) {
		return dao.findByDictCode(dto);
	}
	
}
