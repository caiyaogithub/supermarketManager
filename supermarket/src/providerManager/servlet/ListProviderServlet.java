package providerManager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;
import providerManager.vo.Provider;
/**
 * 
 * @description 显示供应商信息 
 * 
 * @author caiyao
 *
 */
public class ListProviderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			ArrayList<Provider> providerList = new ProviderService().allProvider() ;
			req.setAttribute("providerlist", providerList ) ;
			req.getRequestDispatcher("../providerManager/providerList.jsp").forward(req, resp ) ;
		}catch(Exception e ){
			e.printStackTrace(); 
			req.getRequestDispatcher("../error.jsp").forward(req, resp) ;
		}
	}
}
