package cn.cultivator.shop.service;

import cn.cultivator.shop.pojo.Account;

public interface AccountService extends BaseService<Account>{
	public Account login(Account account);
}
