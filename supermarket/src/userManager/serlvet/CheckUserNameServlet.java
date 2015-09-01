package userManager.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.service.UserService;
/**
 * 
 * @description 检查UserName是否重复
 *
 * @author hello world
 *
 */
public class CheckUserNameServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("name") ;
		try{
			if(!new UserService().checkUserNameExist(userName)){
				resp.getWriter().print("") ;
			}else{
				resp.setCharacterEncoding("utf-8") ;
				resp.getWriter().print("用户名已经存在 ");
			}
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp");
		}
	}
}
