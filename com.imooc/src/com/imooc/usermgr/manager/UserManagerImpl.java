package com.imooc.usermgr.manager;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.usermgr.entity.Log;
import com.imooc.usermgr.entity.User_1;
@Repository("userManager")
@Transactional(readOnly=true)
public class UserManagerImpl  implements UserManager {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private LogManager logManager;
	@Transactional
	public void addUser(User_1 user_1) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(user_1);
		
		Log log=new Log();
		log.setType("增加东西");
		log.setDetail("++++++++++++++");
		log.setTime(new Date());
		
		
		
		logManager.addLog(log);
		
	}
	public void modifyUser(int id,String name){
		Session session=sessionFactory.getCurrentSession();
		User_1 user_1=(User_1)session.load(User_1.class, id);
		user_1.setName(name);
		
	}
	
	public List findAllUser(){
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from User_1").list();
	}
	public List findRangeUser(int minFirstResult,int maxResults){
		Session session=sessionFactory.getCurrentSession();
		List list=session.createQuery("from User_1")
				.setFirstResult(minFirstResult)
				.setMaxResults(maxResults)
				.list();
		

				
		return list;
	}
	public List findUserSingleColumn(){
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("select name from User_1 ").list();
	}


}
