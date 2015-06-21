package cn.cultivator.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import cn.cultivator.shop.pojo.Category;
import cn.cultivator.shop.pojo.Goods;
import cn.cultivator.shop.service.CategoryService;
import cn.cultivator.shop.service.GoodsService;
@SuppressWarnings("unused")
public class ShopTimerTask extends TimerTask {
	private CategoryService categoryService = null;
	private GoodsService goodsService = null;
	private ServletContext application =null;
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@Override
	public void run() {
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		for(Category temp : categoryService.queryByChot(true)){
			bigList.add(goodsService.queryGoodsByCid(temp.getCid()));
		}
		application.setAttribute("bigList", bigList);
	}

}
