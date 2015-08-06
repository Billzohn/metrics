package metrics.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LogUtilFilter
 */
@WebFilter("/*")
public class LogUtilFilter implements Filter {

	private static final ThreadLocal<String> baseLog = new ThreadLocal<String>();

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		StringBuffer baseLogStr = new StringBuffer();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		Map<String, String[]> params = request.getParameterMap();
		StringBuffer paramsStr = new StringBuffer();
		for (String key : params.keySet()) {
			StringBuffer values = new StringBuffer();
			for (String value : params.get(key)) {
				values.append(value).append(",");
			}
			values.deleteCharAt(values.length() - 1);
			paramsStr.append(key).append(values).append(";");
		}
		baseLogStr.append("远程主机：").append(remoteHost).append(":")
				.append(remotePort).append("； 远程地址：").append(remoteAddr)
				.append("；参数：").append(paramsStr).append("。");
		baseLog.set(baseLogStr.toString());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void destroy() {

	}

	public static String getBaseLog() {
		String base = baseLog.get();
		baseLog.remove();
		return base;
	}

}
