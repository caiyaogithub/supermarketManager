package providerManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;
import providerManager.vo.Provider;
/**
 * 
 * @description 查看单个供应商
 *
 * @author hello world
 *
 */
public class SingleProviderServlet extends HttpServlet {
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
			Provider provider = new ProviderService().findProviderById(id) ;
			req.setAttribute("providerInfo", provider) ;
			req.getRequestDispatcher("../providerManager/singleProvider.jsp").forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp") ;
		}
	}
}	
