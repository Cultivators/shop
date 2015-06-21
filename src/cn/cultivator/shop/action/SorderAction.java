package cn.cultivator.shop.action;

import cn.cultivator.shop.pojo.Forder;
import cn.cultivator.shop.pojo.Sorder;

@SuppressWarnings("serial")
public class SorderAction extends BaseAction<Sorder> {

	public String addSorder(){
		Forder forder = (Forder) session.get("forder");
		forder = sorderService.addSorder(forder, model);
		forder.setFtotal(sorderService.culFtotal(forder));
		session.put("forder", forder);
		return "showCar";
	}
	public String removeSorder(){
		int gid = model.getGoods().getGid();
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.removeSorder(forder,gid);
		forder.setFtotal(sorderService.culFtotal(forder));
		session.put("forder", forder);
		jsonMap.put("ftotal", forder.getFtotal());
		return "json1";
	}
}
