package com.lin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dao.ClassDao;
import com.lin.domain.Classes;
@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassDao classDao;
	@Override
	public Classes selectClassFetchUser(String name) {
		// TODO Auto-generated method stub
		return classDao.selectClassFetchUser(name);
	}
	public void insert(Classes classes){
		classDao.insert(classes);
		
	}
	public List<Classes> selectClasses(){
		 return classDao.selectClasses();
	}
	public Classes selectClassesById(int id){
		return classDao.selectClassesById(id);
	}
	public List<Classes> selectClassesExceptOne(int id){
		return classDao.selectClassesExceptOne(id);
	}
}
