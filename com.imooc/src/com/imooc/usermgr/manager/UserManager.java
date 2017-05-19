package com.imooc.usermgr.manager;

import java.util.List;

import com.imooc.usermgr.entity.User_1;

public interface UserManager {
	public void addUser(User_1 user);
	public void modifyUser(int id,String name);
	public List<User_1> findAllUser();
	public List<User_1>  findRangeUser(int minFirstResult,int maxResults);
	public List<User_1>  findUserSingleColumn();
}
