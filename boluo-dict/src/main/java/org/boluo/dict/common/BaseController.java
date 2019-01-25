package org.boluo.dict.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.smart.mvc.util.StringUtils;
import com.xxl.conf.core.XxlConfClient;
import com.smart.mvc.config.ConfigUtils;
import com.smart.mvc.model.Result;

public class BaseController {
	/**
	 * 配置中心项目名称
	 */
	protected String appCode=ConfigUtils.getProperty("app_code");
	
	private Integer[] getAjaxIds(final String str, final String separator) {
		Integer[] ids = null;
		if (str != null) {
			String[] strs = str.split(separator);
			ids = new Integer[strs.length];
			for (int i = 0, length = strs.length; i < length; i++) {
				ids[i] = Integer.valueOf(strs[i]);
			}
		}
		return ids;
	}

	protected List<Integer> getAjaxIds(final String ids) {
		return StringUtils.isBlank(ids) ? new ArrayList<Integer>(0) : Arrays.asList(getAjaxIds(ids, ","));
	}
	
	protected Result createSuccessResult() {
		Result result=Result.createSuccessResult();
		String version = XxlConfClient.get(appCode+".version", "1.0");
		result.setVersion(version);
		return result;
	}

}
