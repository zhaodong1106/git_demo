package com.imooc.usermgr.manager;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.usermgr.entity.User_1;


public class client {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		
		BeanFactory beanfactory=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserManager userManager=(UserManager)beanfactory.getBean("userManager");
		
//		User_1 user=new User_1();
//		user.setId(0);
//		user.setName("zhaodong");
//		userManager.addUser(user);
		List<User_1> list=userManager.findRangeUser(1, 2);
		for(User_1 user:list){
			System.out.println(user.getName());
		}
		
//		usermanager.modifyUser(2, "案发付付付付付付");
//		for(Iterator iter=usermanager.findRangeUser(1, 3).iterator();iter.hasNext();){
//			User_1 user_1=(User_1)iter.next();
//			System.out.println("id:"+user_1.getId()+"  "+"name:"+user_1.getName());
//		}
		
		
		
	}

}
