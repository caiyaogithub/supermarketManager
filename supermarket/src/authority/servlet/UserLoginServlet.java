package authority.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authority.service.LoginService;
/**
 * 
 * @description 处理普通用户登录Servlet 
 * 
 * @author caiyao
 *
 */
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("name") ;
		String userPassword = req.getParameter("password") ;
		try{
			if(new LoginService().checkExist(userName , userPassword , 0 )){
				req.getSession().setAttribute("userlogin", userName) ;
				req.getSession().setAttribute("currentLogin", "user") ;
				resp.sendRedirect("../commonUser/user_main.jsp") ;
			}else{
				resp.sendRedirect("../user_login.jsp?result=1") ;
			}
		}catch(Exception e ){
			e.printStackTrace();
			resp.sendRedirect("error.jsp") ;
		}
		
	}
}
