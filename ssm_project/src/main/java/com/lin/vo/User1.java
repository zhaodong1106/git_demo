package com.lin.vo;

import com.lin.domain.Classes;

public class User1 {

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", classes=" + classes + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private int userId;
	private String userName;
	private Classes classes;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
}
