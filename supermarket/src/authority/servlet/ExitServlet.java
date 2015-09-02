package authority.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @description 退出系统
 *
 * @author hello world
 *
 * @modifyTime 2015年9月2日
 */
public class ExitServlet extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doPost(req, resp) ;
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String admin = (String)req.getSession().getAttribute("admin") ;
		String user = (String)req.getSession().getAttribute("userlogin") ;
		
		if((admin == null || admin.equals("")) && ((user == null || user.equals("")))){
			// 这是一个异常登陆
			System.out.println("用户异常登陆： 没有登陆就直接进入了功能页面") ;
		}
		// 将session中userlogin和admin属性的值设置为""
		req.getSession().setAttribute("admin","") ;
		req.getSession().setAttribute("userlogin","") ;
		resp.sendRedirect("../userLogin.jsp") ;
	}
}
