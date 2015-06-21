package cn.cultivator.shop.service.impl;

import java.util.Set;

import cn.cultivator.shop.pojo.Forder;
import cn.cultivator.shop.pojo.Sorder;
import cn.cultivator.shop.service.SorderService;

public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements SorderService{

	public Forder addSorder(Forder forder, Sorder sorder) {
		boolean isHave = false;
		Set<Sorder> sorders = forder.getSorders();
		for (Sorder temp : sorders) {
			if (temp.getGoods().getGid().equals(sorder.getGoods().getGid())) {
				temp.setSnumber(temp.getSnumber() + 1);
				isHave = true;
				break;
			}
		}
		// 没有重复购物项, 新增到购物车集合中
		if (!isHave) {
			// 也要把购物车添加到购物项中
			sorder.setForder(forder);
			sorders.add(sorder);
		}
		// forder.setSorders(sorders);
		return forder;
	}

	public double culFtotal(Forder forder) {
		double ftotal = 0.0;
		for(Sorder temp : forder.getSorders()){
			ftotal += temp.getSnumber()*temp.getSprice();
		}
		return ftotal;
	}

	public Forder removeSorder(Forder forder, int gid) {
		Set<Sorder> sorders = forder.getSorders();
		for(Sorder temp : sorders){
			if(temp.getGoods().getGid().equals(gid)){
				sorders.remove(temp);
				break;
			}
		}
		return forder;
	}
}