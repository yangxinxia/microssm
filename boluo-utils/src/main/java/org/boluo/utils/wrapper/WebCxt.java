package org.boluo.utils.wrapper;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.boluo.utils.wrapper.impl.HashDto;
import org.boluo.utils.wrapper.util.StringUtils;

import com.alibaba.fastjson.JSONObject;



/**
 * Web上下文
 * 
 * @author xiongchun
 */
public class WebCxt {

	/**
	 * 将Request请求参数封装为Dto对象
	 * 
	 * @param request
	 * @return
	 */
	public static Dto getParamAsDto(HttpServletRequest request) {
		Dto dto = new HashDto();
		Map<String, String[]> map = request.getParameterMap();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Iterator<String> keyIterator = (Iterator) map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String value = map.get(key)[0];
			if("sort".equals(key)) {
				SortVo sortVo = JSONObject.parseObject(value, SortVo.class);
				String property = StringUtils.camelhumpToUnderline(sortVo.getProperty());
				sortVo.setProperty(property);
				dto.put(key, sortVo);
			}else {
				dto.put(key, value);
			}
		}
		return dto;
	}
	
}
