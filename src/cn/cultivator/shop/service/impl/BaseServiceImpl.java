package cn.cultivator.shop.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.cultivator.shop.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	protected HibernateTemplate hibernateTemplate = null;
	private Class<T> clazz =  null;
	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void save(T t) {
		hibernateTemplate.save(t);
	}

	public void delete(int id) {
		Object object = hibernateTemplate.get(clazz, id);
		if(object!=null){
			hibernateTemplate.delete(object);
		}
	}

	public void update(T t) {
		hibernateTemplate.update(t);
	}

	public T get(int id) {
		return hibernateTemplate.get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> query() {
		return hibernateTemplate.find("FROM "+clazz.getSimpleName());
	}

}
