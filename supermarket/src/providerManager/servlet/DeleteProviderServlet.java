package providerManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;

/**
 * 
 * @description É¾³ý¹©Ó¦ÉÌ
 *
 * @author hello world
 *
 */
public class DeleteProviderServlet extends HttpServlet {
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
			new ProviderService().deleteProviderById(id) ;
			resp.getWriter().print("success") ;			
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}
