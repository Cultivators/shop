package cn.cultivator.shop.action;

import java.util.List;

import cn.cultivator.shop.pojo.Category;

public class CategoryAction extends BaseAction<Category>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3030075023390532237L;
	
	public String save(){
		categoryService.save(model);
		//在上传商品的时候更新商品类型
		application.put("categorys", categoryService.query());
		return "query";
	}
	public String query(){
		request.put("categorys", categoryService.queryByCtype(model.getCtype()));
		return "query";
	}
	public void update(){
		categoryService.update(model);
	}
	public void delete(){
		categoryService.delete(model.getCid());
	}

}
