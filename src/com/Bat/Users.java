package com.Bat;


public class Users {
	private int userID;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	Users() {
		
	}

	public Users(String firstName, String lastName, String email,
			String password) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID ;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toStringUserID() {
		return "Id is: " + this.getUserID();
	}
	
	
}
