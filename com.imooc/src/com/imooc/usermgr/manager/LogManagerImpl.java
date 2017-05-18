package com.imooc.usermgr.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.usermgr.entity.Log;
@Repository

public class LogManagerImpl implements LogManager {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional(propagation=Propagation.REQUIRED)
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(log);
	}


}
