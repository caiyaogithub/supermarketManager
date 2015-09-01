package authority.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @description 直接访问Admin_main.jsp页面 
 * 
 * @author caiyao
 *
 */
public class VisitAdminMainPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 1. 判断session中Admin字段是否有值
		 * 2. 如果有值，则转向admin_main.jsp页面
		 * 3. 如果没有值，则转向admin_login.jsp页面
		 */
		if(req.getSession().getAttribute("admin") != null ){
			req.getRequestDispatcher("admin/admin_main.jsp") ;
		}else{
			resp.sendRedirect("admin_login.jsp") ;
		}
	}
}
