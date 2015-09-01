package billManager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import billManager.service.BillService;
import billManager.vo.Bill;
/**
 * 
 * @description 显示账单信息 
 * 
 * @author caiyao
 *
 */
public class ListBillServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			ArrayList<Bill> billList = new BillService().allBill() ;
			req.setAttribute("billlist", billList ) ;
			req.getRequestDispatcher("../billManager/billList.jsp").forward(req, resp ) ;
		}catch(Exception e ){
			e.printStackTrace(); 
			req.getRequestDispatcher("../error.jsp").forward(req, resp) ;
		}
	}
}
