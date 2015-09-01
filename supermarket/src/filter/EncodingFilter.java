package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @description 设置请求和回应编码 ，处理中文乱码问题
 * 
 * @author caiyao
 *
 */
public class EncodingFilter implements Filter {
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		filter.doFilter(request, response);
		response.setCharacterEncoding("utf-8");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
