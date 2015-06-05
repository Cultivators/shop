package cn.cultivator.shop.service.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.cultivator.shop.pojo.Catagory;

public class CatagoryServiceImpl {
	private HibernateTemplate hibernateTemplate = null;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void save(Catagory catagory) {
		hibernateTemplate.save(catagory);
		
	}
}
