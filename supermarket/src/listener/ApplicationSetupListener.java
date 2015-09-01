package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.Constrant;

/**
 * 
 * @description 应用启动时执行初始化操作
 *
 * @author hello world
 *
 * @modifyTime 2015年9月1日
 */
public class ApplicationSetupListener implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 设置服务器路径
		String serverPath = sce.getServletContext().getRealPath("/") ;
		Constrant.SERVER_PATH = serverPath ;
	}
}
