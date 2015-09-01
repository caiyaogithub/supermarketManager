package providerManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import providerManager.service.ProviderService;
/**
 * 
 * @description 检查ProviderName是否重复
 *
 * @author hello world
 *
 */
public class CheckProviderNameServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp) ;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ProviderName = req.getParameter("name") ;
		try{
			if(!new ProviderService().checkProviderNameExist(ProviderName)){
				resp.getWriter().print("") ;
			}else{
				resp.setCharacterEncoding("utf-8") ;
				resp.getWriter().print("供应商名已经存在 ");
			}
		}catch(Exception e ){
			e.printStackTrace() ;
			resp.sendRedirect("../error.jsp");
		}
	}
}
