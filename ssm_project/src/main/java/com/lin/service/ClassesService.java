package com.lin.service;


import java.util.List;

import com.lin.domain.Classes;

public interface ClassesService {
	public Classes selectClassFetchUser(String name);
	public void insert(Classes classes);
	public List<Classes> selectClasses();
	public Classes selectClassesById(int id);
	public List<Classes> selectClassesExceptOne(int id);
}
