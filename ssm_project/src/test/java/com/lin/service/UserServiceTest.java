package com.lin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Tuple;


import com.github.pagehelper.PageHelper;
import com.lin.baseTest.SpringTestCase;
import com.lin.domain.User;
import com.lin.redis.UserRedisDaoImpl;
import com.lin.vo.User1;

public class UserServiceTest extends SpringTestCase {
	@Autowired
	private UserService userService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	@Autowired
	private RedisTemplate<String,List<User>> redisTemplate;
//	@Autowired
//	private RedisTemplate<String, String> redisTemplate1;
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
		List<User> list=userService.selectUserLike("С");
		for(User user:list){
			System.out.println(user);
		}
	}

	@Test
	public void selectAllUserJoinClass(){
		
		List<User> list=(List<User>) redisTemplate.opsForValue().get("list100");
		if(list==null){
		 list=userService.selectAllUserJoinClass();
		 redisTemplate.opsForValue().set("list100", list);
		}
		for(User user:list){
		System.out.println(user);}
		
		
		
		
			
			
			
			
//		}
		
		
	}
	
	@Test
	public void testRedis2(){
		stringRedisTemplate.opsForZSet().add("studentScore", "李伟", 124);
		stringRedisTemplate.opsForZSet().add("studentScore", "赵俊生", 135);
		Set<TypedTuple<String>> set1=stringRedisTemplate.opsForZSet().reverseRangeWithScores("studentScore", 0, 10);
		for(TypedTuple<String> string1:set1){
			System.out.println("学生："+string1.getValue()+" 分数："+string1.getScore());
		}
	}
	
	@Test
	public void testSpringDataRedis(){
		List<User> list=redisTemplate.opsForValue().get("list100");
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
		int a=userService.selectUserByName("�Զ�1");
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
