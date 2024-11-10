package com.user.model;

public class user {
	
	private String user_id; 
	private String user_name;
	private String email_id;
	private String pass_word;
	private int age;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String user_id, String user_name, String email_id, String pass_word, int age) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email_id = email_id;
		this.pass_word = pass_word;
		this.age = age;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_name=" + user_name + ", email_id=" + email_id + ", pass_word="
				+ pass_word + ", age=" + age + "]";
	}
	
	
	
}
