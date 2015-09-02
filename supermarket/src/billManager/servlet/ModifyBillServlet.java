package billManager.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import billManager.service.BillCheck;
import billManager.service.BillService;
import billManager.vo.Bill;
import exception.FormDataException;
/**
 * 
 * @description 修改供应商信息
 *
 * @author hello world
 *
 */
public class ModifyBillServlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			int id = Integer.parseInt(req.getParameter("id")) ;
			int providerId = Integer.parseInt(req.getParameter("provider")) ;
			double price = Double.parseDouble(req.getParameter("price")) ;
			String priceUnit = req.getParameter("goodsUnit");
			int goodsNum = Integer.parseInt(req.getParameter("goodsNum")) ;
			String isPay = req.getParameter("isPay") ;
			String goodsName = req.getParameter("goodsName") ;
			String goodsDesc = req.getParameter("goodsDesc") ;
			Timestamp billTime = Timestamp.valueOf(req.getParameter("billTime")) ;
			Bill bill = new Bill(id,providerId ,price ,priceUnit, goodsNum , isPay ,goodsName, goodsDesc ,billTime) ;
			if(!new BillCheck().checkBill(bill)){
				throw new FormDataException("表单数据填写错误") ;
			}
			new BillService().modifyBill(bill) ;
			// 修改成功转向成功提示页面
			req.setAttribute("modifyResultInfo", "修改成功") ;
			// 设置提示后转向的页面
			req.setAttribute("redirectURI", "../billManager/listBill") ;
			// 设置转向页面名称
			req.setAttribute("redirectPageName", "账单列表" );
			// 转发到成功提示页面
			req.getRequestDispatcher("../billManager/result.jsp").forward(req, resp) ;
		}catch(NumberFormatException e ){
			e.printStackTrace() ; 
			resp.sendRedirect("../billManager/singleBill?id=" + Integer.parseInt(req.getParameter("id")) );
		}catch(FormDataException e ){
			e.printStackTrace() ;
			resp.sendRedirect("../billManager/singleBill?id=" + Integer.parseInt(req.getParameter("id")) );
		}catch(Exception e ){
			e.printStackTrace() ; 
			resp.sendRedirect("../error.jsp") ;
		}
	}
}
