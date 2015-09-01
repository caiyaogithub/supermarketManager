package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @description 拦截访问admin/、userManager/下的资源(包括JSP页面和servlet)，首先判断session中admin字段是否有值，即admin是否登录 
 * 
 * @author caiyao
 *
 *
 */
public class AdminAuthorityControlFilter implements Filter {
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {
		System.out.println("进入filter");
		HttpSession session = ((HttpServletRequest)req).getSession() ;
		if(session.getAttribute("admin") != null ){
			filter.doFilter(req, resp) ;
		}else{
			/*admin用户没有登录，转向登录页面*/
			((HttpServletResponse)resp).sendRedirect("/supermarket/admin_login.jsp") ;
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
