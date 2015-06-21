package cn.cultivator.shop.action;

import cn.cultivator.shop.pojo.Forder;
import cn.cultivator.shop.pojo.Status;
import cn.cultivator.shop.pojo.Users;

public class ForderAction extends BaseAction<Forder>{

	private static final long serialVersionUID = -3207594490975977681L;
	
	public String save(){
		Forder forder = (Forder) session.get("forder");
		forder.setFemail(model.getFemail());
		forder.setFname(model.getFname());
		forder.setFphone(model.getFphone());
		forder.setFpost(model.getFpost());
		forder.setFremark(model.getFremark());
		Status status = new Status();
		status.setSid(1);
		forder.setStatus(status);
		forder.setUsers((Users)session.get("users"));
		forderService.save(forder);
		return "bank";
	}
}
