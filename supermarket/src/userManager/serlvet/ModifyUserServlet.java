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
 * @description 修改用户信息
 *
 * @author hello world
 *
 */
public class ModifyUserServlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name") ;
		String password = req.getParameter("password") ;
		String gender = req.getParameter("gender") ;
		int age = Integer.parseInt(req.getParameter("age")) ;
		String telephone = req.getParameter("telephone") ;
		String address = req.getParameter("address") ;
		System.out.println("id: " + id + " name : " + name + "password： " + password );
		User user = new User(id , name , password , gender , age , telephone , address , 0) ;
		try{
			if(!new UserCheck().checkUser(user)){
				throw new Exception() ;
			}
			new UserService().modifyUser(user) ;
			// 修改成功转向成功提示页面
			req.setAttribute("modifyResultInfo", "修改成功") ;
			// 设置提示后转向的页面
			req.setAttribute("redirectURI", "../userManager/listUser") ;
			// 设置转向页面名称
			req.setAttribute("redirectPageName", "用户列表" );
			// 转发到成功提示页面
			req.getRequestDispatcher("../userManager/result.jsp").forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ; 
			req.setAttribute("modifyResultInfo", "修改失败") ;
			// 设置提示后转向的页面
			req.setAttribute("redirectURI", "../userManager/listUser") ;
			// 设置转向页面名称
			req.setAttribute("redirectPageName", "用户列表" ) ;
			// 转发到成功提示页面
			req.getRequestDispatcher("../userManager/result.jsp").forward(req, resp) ;
		}
	}
}
