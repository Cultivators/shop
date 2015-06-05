package cn.cultivator.shop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cultivator.shop.pojo.Catagory;
import cn.cultivator.shop.service.impl.CatagoryServiceImpl;

public class SSHTest {
	@Test
	public void testSpring(){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		System.out.println(aContext.getBean("date"));
	}
	@Test
	public void testHibernate(){
		System.out.println(HibernateSessionFactory.getSession());
	}
	@Test
	public void testSpringHibernate(){
		ApplicationContext acApplicationContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		CatagoryServiceImpl catagoryServiceImpl = (CatagoryServiceImpl) acApplicationContext.getBean("catagoryServiceImpl");
		Catagory catagory = new Catagory("test", true, 2);
		catagoryServiceImpl.save(catagory);
		
	}
	public String execute(){
		System.out.println("=====执行Action======");
		return "success";
	}
	
}
