package com.gcu.data.entity;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.*;

@Table("Users")
public class UserEntity {

	@Id
    @Column("userid")
	Long userID;

    @NotEmpty(message = "First Name is required")
	@Column("firstName")
	String firstName;

    @NotEmpty(message = "Last Name is required")
	@Column("lastName")
	String lastName;

    @NotEmpty(message = "Email is required")
	@Column("email")
	String email;

    @NotEmpty(message = "Phone Number is required")
	@Column("phoneNumber")
	String phoneNumber;

    @NotEmpty(message = "Username is required")
	@Column("username")
	String username;

    @NotEmpty(message = "Password is required")
	@Column("password")
	String password;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserEntity() {
		
	}

	public UserEntity(Long userID, String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	
	
	
}
