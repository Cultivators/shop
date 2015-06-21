package cn.cultivator.shop.service;

import cn.cultivator.shop.pojo.Users;


public interface UsersService extends BaseService<Users>{
	public Users login(Users users);
}
