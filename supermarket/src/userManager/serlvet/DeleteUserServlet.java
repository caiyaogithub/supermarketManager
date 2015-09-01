package userManager.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.service.UserService;

/**
 * 
 * @description É¾³ýÓÃ»§
 *
 * @author hello world
 *
 */
public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		System.out.println("id: " + id) ;
		try{
			new UserService().deleteUserById(id) ;
			resp.getWriter().print("success") ;			
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}
