package org.boluo.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.boluo.utils.wrapper.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 解决跨域访问的问题
 * 
 * @author yangxinxia 2019-01-15
 *
 */
public class AccessControlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-Origin", "*"); // 设置允许所有跨域访问
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,OPTIONS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin,X-Requested-With,Content-Type,Accept,Authorization,token,__vt_param__");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		//response.setHeader("Set-Cookie", "name=value; Path=/;Domain=.boluo.com;Max-Age=seconds;HTTPOnly");
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {

	}

}
