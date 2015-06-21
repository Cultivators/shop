package cn.cultivator.shop.service.impl;

import java.util.List;

import cn.cultivator.shop.pojo.Account;
import cn.cultivator.shop.service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	
	public AccountServiceImpl(){
		super();
	}
	
	public Account login(Account account) {
		@SuppressWarnings({ "unchecked", "unused" })
		List<Account> accounts = hibernateTemplate.findByNamedParam(
				"From Account a WHERE a.alogin=:alogin AND a.apass=:apass ", 
				new String[]{"alogin","apass"}, 
				new Object[]{account.getAlogin(),account.getApass() });
 		return accounts.size()>0 ? accounts.get(0):null;
	}
}
