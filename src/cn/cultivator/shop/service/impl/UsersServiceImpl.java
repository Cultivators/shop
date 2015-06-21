package cn.cultivator.shop.service.impl;

import java.util.List;

import javax.xml.registry.infomodel.User;

import cn.cultivator.shop.pojo.Users;
import cn.cultivator.shop.service.UsersService;

public class UsersServiceImpl extends BaseServiceImpl<Users> implements UsersService{

	@SuppressWarnings("unchecked")
	public Users login(Users users) {
		List<Users> usersList = hibernateTemplate.findByNamedParam("FROM Users u WHERE u.ulogin=:ulogin AND u.upass =:upass",
				new String[]{"ulogin","upass"}, new Object[] {users.getUlogin(),users.getUpass()});
		return (usersList.size()>0?usersList.get(0):null);
	}

}
