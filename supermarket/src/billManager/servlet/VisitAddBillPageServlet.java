package billManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;

/**
 * 
 * @description 访问billManager.jsp页面。
 *              主要是为了在访问添加订单页面之前将所有供应商信息设置进req中，
 *              方便在addBill.jsp页面中显示
 *
 * @author hello world
 *
 */
public class VisitAddBillPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			String result = req.getParameter("result") ;
			req.setAttribute("providers", new ProviderService().allProvider() ) ;
			req.getRequestDispatcher("../billManager/addBill.jsp?result" + result ).forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
		
	}
}
