package cn.cultivator.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.cultivator.shop.service.CategoryService;
import cn.cultivator.shop.util.FileUploadUtil;
import cn.cultivator.shop.util.ShopTimerTask;

public class ShopServletContextListener implements ServletContextListener{
	private ApplicationContext context = null;
	private CategoryService categoryService = null;
	private ShopTimerTask shopTimerTask = null;
	private FileUploadUtil fileUploadUtil = null;
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent se) {
		context = WebApplicationContextUtils.getWebApplicationContext(se.getServletContext());
		categoryService = (CategoryService)context.getBean("categoryService");
		fileUploadUtil = (FileUploadUtil) context.getBean("fileUploadUtil");
		se.getServletContext().setAttribute("categorys", categoryService.query());
		//线程更新时间确定
		shopTimerTask = (ShopTimerTask)context.getBean("shopTimerTask");
		shopTimerTask.setApplication(se.getServletContext());
		new Timer(true).schedule(shopTimerTask, 0, 60*1000);
		String imagePath = se.getServletContext().getRealPath("/image/logo");
		se.getServletContext().setAttribute("bankImage", fileUploadUtil.getBankImage(imagePath));
	}

}
