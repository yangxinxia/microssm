package org.boluo.utils.wrapper.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;


public class RequestUtils {
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			}
			else {
				return ip;
			}
		}
		else {
			return request.getRemoteAddr();
		}
	}
	
    public static String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for(Entry<String,String[]> e:map.entrySet()){
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if(value != null && value.length == 1){
                sb.append(value[0]).append("\t");
            }else{
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }
}
