package billManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import billManager.service.BillService;

/**
 * 
 * @description É¾³ýÕËµ¥
 *
 * @author hello world
 *
 */
public class DeleteBillServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = (int)Double.parseDouble(req.getParameter("id")) ;
		System.out.println("id: " + id) ;
		try{
			new BillService().deleteBillById(id) ;
			resp.getWriter().print("success") ;			
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}
