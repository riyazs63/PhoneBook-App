package com.model;

public class Contact {

	private int id;
	private String name;
	private String email;
	private String phno;
	private String about;
	private int UserId;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String name, String email, String phno, String about, int userId) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.about = about;
		UserId = userId;
	}
	
	public Contact(int id, String name, String email, String phno, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.about = about;
	}
	
	public Contact(String name, String email, String phno, String about) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.about = about;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
}
