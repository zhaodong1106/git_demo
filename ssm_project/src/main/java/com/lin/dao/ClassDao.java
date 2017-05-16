package com.lin.dao;

import java.util.List;

import com.lin.domain.Classes;

public interface ClassDao {
	public Classes selectClassFetchUser(String name);
	public void insertBatch(List<Classes> list);
	public void insert(Classes classes);
	public List<Classes> selectClasses();
	public Classes selectClassesById(int id);
	public List<Classes> selectClassesExceptOne(int id);
}
