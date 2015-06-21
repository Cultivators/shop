package cn.cultivator.shop.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.cultivator.shop.pojo.Forder;

public class ShopHttpSessionListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("------forder创建------");
		se.getSession().setAttribute("forder", new Forder());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
