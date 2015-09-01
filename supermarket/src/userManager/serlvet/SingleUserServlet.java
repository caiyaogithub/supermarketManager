package userManager.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.service.UserService;
import userManager.vo.User;
/**
 * 
 * @description 查看单个用户
 *
 * @author hello world
 *
 */
public class SingleUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		try{
			User user = new UserService().findUserById(id) ;
			req.setAttribute("userInfo", user) ;
			req.getRequestDispatcher("../userManager/singleUser.jsp").forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}	
