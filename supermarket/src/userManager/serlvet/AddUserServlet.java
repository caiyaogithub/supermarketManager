package userManager.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.service.UserCheck;
import userManager.service.UserService;
import userManager.vo.User;
/**
 * 
 * @description ÃÌº””√ªß 
 * 
 * @author caiyao
 *
 */
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("username") ;
		String password = req.getParameter("password") ;
		String gender = req.getParameter("gender").trim() ;
		if(!req.getParameter("age").matches("[0-9]+")){
			resp.sendRedirect("../userManager/addUser.jsp?result=1") ;
			return ;
		}
		int age = Integer.parseInt(req.getParameter("age")) ;
		String telephone = req.getParameter("telephone") ;
		String address = req.getParameter("address") ;
		
		User user = new User(userName , password , gender ,  age , telephone , address , 0 ) ;
		
		try{
			if(!new UserCheck().checkUser(user) || new UserService().checkUserNameExist(userName)){
				resp.sendRedirect("../userManager/addUser.jsp?result=1") ;
				return ;
			}
			new UserService().addUser(user) ;
			resp.sendRedirect("listUser") ;
		}catch(Exception e ){
			e.printStackTrace() ; 
			resp.sendRedirect("../error.jsp");
		}
 	}
}
