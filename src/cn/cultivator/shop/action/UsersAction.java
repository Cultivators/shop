package cn.cultivator.shop.action;

import cn.cultivator.shop.pojo.Users;

public class UsersAction extends BaseAction<Users>{

	private static final long serialVersionUID = 941945761500149462L;
	
	private String goUrl=null;
	
	public String getGoUrl() {
		return goUrl;
	}

	public void setGoUrl(String goUrl) {
		this.goUrl = goUrl;
	}

	public String login(){
		Users users = usersService.login(model);
		//登录失败
		if(users==null){
			request.put("error", "非法登录");
			return "login";
		}else{
			//登录成功后分为两种：1、首页登录 2、提交订单之前登录
			session.put("users", users);
			//判断的依据是:goUrl不为空则进行了过滤
			if(session.get("goUrl")!=null){
				goUrl=session.get("goUrl").toString();
				return "aa";
			}else{
				return "index";
			}
		}
	}
}
