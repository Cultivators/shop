package cn.cultivator.shop.service;

import java.util.List;

import cn.cultivator.shop.pojo.Category;

public interface CategoryService extends BaseService<Category>{
	public List<Category> queryByChot(boolean chot);
	public List<Category> queryByCtype(String ctype);
}
