package cn.cultivator.shop.action;

import java.util.List;

import cn.cultivator.shop.pojo.Account;

public class AccountAction extends BaseAction<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6800185139423416073L;
	
	public AccountAction(){
		System.out.println("----AccountAction()----");
	}
	public String save(){
		accountService.save(model);
		return "main";
	}
	public String get(){
		request.put("account", accountService.get(model.getAid()));
		return "update";
	}
	public String delete(){
		accountService.delete(model.getAid());
		List<Account> accounts = accountService.query();
		request.put("accounts", accounts);
		return "query";
	}
	public String update(){
		accountService.update(model);
		return "main";
	}
	public String query(){
		List<Account> accounts = accountService.query();
		request.put("accounts", accounts);
		return "query";
	}
	//登录
	public String login(){
		Account account = accountService.login(model);
		if(account!=null){
			session.put("account", account);
			return "success";
		}else{
			request.put("error", "登录名不存在!");
			return "false";
		}
	}
}
