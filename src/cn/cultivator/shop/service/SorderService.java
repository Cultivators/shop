package cn.cultivator.shop.service;

import cn.cultivator.shop.pojo.Forder;
import cn.cultivator.shop.pojo.Goods;
import cn.cultivator.shop.pojo.Sorder;

public interface SorderService extends BaseService<Sorder>{
	public Forder addSorder(Forder forder,Sorder sorder);
	public double culFtotal(Forder forder);
	public Forder removeSorder(Forder forder,int gid);
	public Sorder get(int gid);
}
