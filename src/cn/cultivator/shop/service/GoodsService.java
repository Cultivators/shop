package cn.cultivator.shop.service;

import java.util.List;

import cn.cultivator.shop.pojo.Goods;

public interface GoodsService extends BaseService<Goods>{
	public List<Goods> queryGoodsByCid(int id);
	public List<Goods> queryGoodsByName(String gname);
}
