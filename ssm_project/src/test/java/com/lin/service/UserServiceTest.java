package com.lin.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.github.pagehelper.PageHelper;
import com.lin.baseTest.SpringTestCase;
import com.lin.domain.User;
import com.lin.vo.User1;

public class UserServiceTest extends SpringTestCase {
	@Autowired
	private UserService userService;
	@Test
	public void testSelectUserById(){
		User user=(User)userService.selectUserById(1);
		System.out.println(user);
	}
	@Test
	public void testSelectUserAll(){
		PageHelper.startPage(1, 6);
		List<User> list=userService.selectUserAll();
		for(User user:list){
			System.out.println(user);
		}
	}
	@Test
	public void testSelectUserLike(){
		List<User> list=userService.selectUserLike("–°");
		for(User user:list){
			System.out.println(user);
		}
	}

	@Test
	public void selectAllUserJoinClass(){
		List<User> list=userService.selectAllUserJoinClass();

		for(User user:list){
			System.out.println(user);
		}
	}
	@Test
	public void testInsertBatch(){
		List<User> list=new ArrayList<User>();
		User user1=new User();
		user1.setUserName("test1");
		user1.setUserPassword("1106");
		user1.setUserEmail("123@qq.com");
		User user2=new User();
		user2.setUserName("test2");
		user2.setUserPassword("1106");
		user2.setUserEmail("123@qq.com");
		list.add(user1);
		list.add(user2);
		userService.insertBatch(list);

	}
	@Test
	public void testSelectUserByClassid(){
		List<User1> list=userService.selectUserByClassid(2);
		for(User1 user:list){
			System.out.println(user);
		}
	}
	@Test
	public void testSelectUserByName(){
		int a=userService.selectUserByName("’‘∂∞1");
		System.out.println(a);
	}
	@Test
	public void testDeleteBatch(){
	int[] array=new int[]{1,2};
		userService.deleteBatch(array);
	}
	@Test
	public void testUserInsert(){
		User user=new User();
		user.setUserName("userName1");
		user.setUserPassword("password1");
		user.setUserEmail("email1");
		
		userService.insert(user);
	}
}
