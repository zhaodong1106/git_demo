package com.lin.service;

import java.util.List;


import com.lin.domain.User;
import com.lin.vo.User1;

public interface UserService {
	public User selectUserById(Integer id);
	public List<User> selectUserAll();
	public List<User> selectUserLike(String description);
	public void insert(User user);
	public List<User> selectAllUserJoinClass();
	public void delete(int id);
	public void update(User user);
	public void insertBatch(List<User> list);
	public void deleteBatch(int[] ids);
	public List<User1> selectUserByClassid(int id);
	public int selectUserByName(String name);
	public int selectUserByEmail(String email);
	public User checkPasswordByName(String name);
	
}
