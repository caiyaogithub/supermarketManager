package billManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;
import billManager.service.BillService;
import billManager.vo.Bill;
/**
 * 
 * @description 查看单个订单
 *
 * @author hello world
 *
 */
public class SingleBillServlet extends HttpServlet {
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
			Bill bill = new BillService().findBillById(id) ;
			req.setAttribute("billInfo", bill) ;
			req.getRequestDispatcher("../billManager/singleBill.jsp").forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}	
