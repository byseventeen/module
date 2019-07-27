package com.stuformBase;

import java.util.Date;

public class Student {
	
	//设置参数
	Integer userId;
	String userName;
	Boolean gender;
	Date birthdate;
	String phone;
	String hobby;
	
	public Student (Integer userId, String userName, Boolean gender,
			Date birthdate, String phone, String hobby) {
		super();
		this.userId=userId;
		this.userName=userName;
		this.gender=gender;
		this.birthdate=birthdate;
		this.phone=phone;
		this.hobby=hobby;
	}
	public String toString(){
		return "Student [userId=" + userId + ", userName=" + userName
				+ ", gender=" + gender + ", birthdate=" + birthdate
				+ ", phone=" + phone + ", hobby=" + hobby + "]";
	}
}
