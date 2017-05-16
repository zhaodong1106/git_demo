package com.lin.domain;

public class User_Classes {
	private int userId;
	private int classId;
	@Override
	public String toString() {
		return "User_Classes [userId=" + userId + ", classId=" + classId + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
}
