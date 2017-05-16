package com.lin.domain;

import java.util.List;

public class Classes {
	private int classId;
	private String className;
	private List<User> list;

	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes( String className) {
		super();
		
		this.className = className;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className
				+ ", list=" + list + "]";
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
