package com.lin.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lin.dao.User_ClassesDao;
import com.lin.domain.User_Classes;

public class User_ClassesServiceImpl {
	@Autowired
	private User_ClassesDao user_classesDao;
	public void insert(User_Classes user_classes){
		user_classesDao.insert(user_classes);
	}
}
