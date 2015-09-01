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
 * @description 根据供应商名和供应商描述模糊查询供应商
 *
 * @author hello world
 */
public class ListProviderByNameAndDescServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String providerName = req.getParameter("name") ;
		String providerDesc = req.getParameter("desc") ;
		try{
			ArrayList<Provider> providers = new ProviderService().findProviderByNameOrDesc(providerName,providerDesc) ;
			req.setAttribute("providerlist", providers ) ;
			req.getRequestDispatcher("../providerManager/providerList.jsp").forward(req, resp ) ;
		}catch(Exception e ){
			e.printStackTrace(); 
			req.getRequestDispatcher("../error.jsp").forward(req, resp) ;
		}
	}
}
