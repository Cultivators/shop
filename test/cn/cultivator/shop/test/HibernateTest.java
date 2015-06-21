package cn.cultivator.shop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	@Test
	public void testHibernate(){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		System.out.println(aContext.getBean("hibernateTemplate"));
	}
}
