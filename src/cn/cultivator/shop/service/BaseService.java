package cn.cultivator.shop.service;

import java.util.List;

public interface BaseService<T> {
	public void save(T t);
	public void delete(int id);
	public void update(T t);
	public T get(int id);
	public List<T> query();
}
