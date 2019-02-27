package org.boluo.dict.jobhandler;

import javax.annotation.Resource;

import org.boluo.dict.service.SysSequenceService;
import org.springframework.stereotype.Component;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;

@JobHandler(value="sysSequenceJobHanlder")
@Component
public class SysSequenceJobHanlder extends IJobHandler{

	@Resource
	private SysSequenceService sysSequenceService;
	
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		sysSequenceService.resetInitVal();
		return SUCCESS;
	}

}
