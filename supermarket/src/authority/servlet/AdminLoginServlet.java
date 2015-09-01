package authority.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authority.service.AdminLoginService;
/**
 * 
 * @description 处理管理员登录Servlet 
 * 
 * @author caiyao
 *
 */
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String adminName = req.getParameter("name") ;
		String adminPassword = req.getParameter("password") ;
		try{
			if(new AdminLoginService().checkExist(adminName , adminPassword )){
				req.getSession().setAttribute("admin", adminName) ;
				/*页面跳转使用重定向，在页面重定向时会经过过滤器判断权限*/
				// 正确跳转方式：
				resp.sendRedirect("../admin/admin_main.jsp") ;
				// 这种方式的跳转URL为： http://localhost:8080/supermarket/authority/admin/admin_main.jsp
				// 当不写斜杠时，默认是根据当前servlet的URL的上一级为基URL
				//resp.sendRedirect("admin/admin_main.jsp") ;
			}else{
				resp.sendRedirect("../admin_login.jsp?result=1") ;
			}
		}catch(Exception e ){
			e.printStackTrace();
			resp.sendRedirect("error.jsp") ;
		}
		
	}
}
