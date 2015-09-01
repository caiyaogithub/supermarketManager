package providerManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderCheck;
import providerManager.service.ProviderService;
import providerManager.vo.Provider;
/**
 * 
 * @description 添加供应商 
 * 
 * @author caiyao
 *
 */
public class AddProviderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String providerName = req.getParameter("providername") ;
		String providerDesc = req.getParameter("providerDesc") ;
		String linkman = req.getParameter("linkman") ;
		String telephone = req.getParameter("telephone") ;
		String fax = req.getParameter("fax") ; 
		String address = req.getParameter("address") ;
		/*String providerName, String providerDesc, String linkMan,
			String telephone, String fax, String address*/
		Provider Provider = new Provider(providerName , providerDesc , linkman , telephone , fax , address ) ;
		
		try{
			if(!new ProviderCheck().checkProvider(Provider) || new ProviderService().checkProviderNameExist(providerName)){
				resp.sendRedirect("../ProviderManager/addProvider.jsp?result=1") ;
				return ;
			}
			new ProviderService().addProvider(Provider) ;
			resp.sendRedirect("listProvider") ;
		}catch(Exception e ){
			e.printStackTrace() ; 
			resp.sendRedirect("../error.jsp");
		}
 	}
}
