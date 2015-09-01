package userManager.serlvet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userManager.service.UserService;
import userManager.vo.User;
/**
 * 
 * @description 显示用户信息 
 * 
 * @author caiyao
 *
 */
public class ListUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			ArrayList<User> userList = new UserService().allUser() ;
			req.setAttribute("userlist", userList ) ;
			req.getRequestDispatcher("../userManager/userList.jsp").forward(req, resp ) ;
		}catch(Exception e ){
			e.printStackTrace(); 
			req.getRequestDispatcher("../error.jsp") ;
		}
	}
}
