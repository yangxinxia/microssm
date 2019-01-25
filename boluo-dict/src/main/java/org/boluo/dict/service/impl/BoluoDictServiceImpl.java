package org.boluo.dict.service.impl;


import org.boluo.dict.dao.BoluoDictDao;
import org.boluo.dict.model.BoluoDict;
import org.boluo.dict.service.BoluoDictService;
import org.boluo.utils.constant.Constant;
import org.boluo.utils.constant.Module;
import org.boluo.utils.rpc.syslog.Servicelog;
import org.boluo.utils.wrapper.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.mvc.model.Pagination;
import com.smart.mvc.service.mybatis.impl.ServiceImpl;


@Service("boluoDictService")
public class BoluoDictServiceImpl extends ServiceImpl<BoluoDictDao,BoluoDict,Integer> implements BoluoDictService{
	@Autowired
	public void setDao(BoluoDictDao dao) {
		this.dao = dao;
		
	}

	/*@Override
	public Pagination<BoluoDict> findPagination(String dictCode,String dictDesc,Integer isEnabel, Pagination<BoluoDict> p) {
		dao.findPagination(dictCode,dictDesc,isEnabel,p)
		return p;
	}*/
	
	@Override
	@Servicelog(sysName=Module.Sys.DICT,module = Module.Dict.DICT,className="BoluoDictServiceImpl",methoed = "findPagination")
	public Pagination<BoluoDict> findPagination(Dto dto, Pagination<BoluoDict> p) {
		dao.findPagination(dto,p);
		return p;
	}

	@Override
	@Servicelog(sysName=Module.Sys.DICT,module = Module.Dict.DICT,className="BoluoDictServiceImpl",methoed = "findByDictCode")
	public BoluoDict findByDictCode(String dictCode,Integer dictId) {
		return dao.findByDictCode(dictCode, dictId,Constant.IsEnabel.ENABEL);
	}

	@Override
	public Integer qryNextVal(String seqName) {
		return dao.qryNextVal(seqName);
	}
}
