package com.lin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.UserDao;
import com.lin.domain.User;
import com.lin.vo.User1;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;


	@Override
	public User selectUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectUserById(id) ;
	}
	public List<User> selectUserAll(){
		return userDao.selectUserAll();
	}
	public List<User> selectUserLike(String description){
		return userDao.selectUserLike(description);
	}
	public void insert(User user){
		userDao.insert(user);
		
	}
	public List<User> selectAllUserJoinClass(){
	 return	userDao.selectAllUserJoinClass();
	}
	public void delete(int id){
		userDao.delete(id);
	}
	public void update(User user){
		userDao.update(user);
	}
	public void insertBatch(List<User> list){
		userDao.insertBatch(list);
	}
	public void deleteBatch(int[] ids){
		userDao.deleteBatch(ids);
	}
	public List<User1> selectUserByClassid(int id){
		return userDao.selectUserByClassid(id);
	}
	public int selectUserByName(String name){
		return userDao.selectUserByName(name);
	}
	public int selectUserByEmail(String email){
		return userDao.selectUserByEmail(email);
	}
	public User checkPasswordByName(String name){
		return userDao.checkPasswordByName(name);
	}
}
