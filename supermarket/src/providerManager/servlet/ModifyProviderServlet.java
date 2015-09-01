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
 * @description 修改供应商信息
 *
 * @author hello world
 *
 */
public class ModifyProviderServlet extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		String name = req.getParameter("name") ;
		String desc = req.getParameter("desc") ;
		String linkman = req.getParameter("linkman") ;
		String telephone = req.getParameter("telephone") ;
		String fax = req.getParameter("fax") ;
		String address = req.getParameter("address") ;
		/*int providerId, String providerName, String providerDesc,
		String linkMan, String telephone, String fax, String address*/
		Provider provider = new Provider(id , name , desc , linkman ,  telephone ,fax , address ) ;
		try{
			new ProviderService().modifyProvider(provider) ;
			// 修改成功转向成功提示页面
			req.setAttribute("modifyResultInfo", "修改成功") ;
			// 设置提示后转向的页面
			req.setAttribute("redirectURI", "../providerManager/listProvider") ;
			// 设置转向页面名称
			req.setAttribute("redirectPageName", "供应商列表" );
			// 转发到成功提示页面
			req.getRequestDispatcher("../providerManager/result.jsp").forward(req, resp) ;
		}catch(Exception e ){
			e.printStackTrace() ; 
			// 修改成功转向成功提示页面
			req.setAttribute("modifyResultInfo", "修改失败") ;
			// 设置提示后转向的页面
			req.setAttribute("redirectURI", "../providerManager/listProvider") ;
			// 设置转向页面名称
			req.setAttribute("redirectPageName", "供应商列表" );
			// 转发到成功提示页面
			req.getRequestDispatcher("../providerManager/result.jsp").forward(req, resp) ;
		}
	}
}
