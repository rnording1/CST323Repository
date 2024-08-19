package com.gcu.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserModel {

    private Long userID;
    @NotEmpty(message = "First Name is required")
    private String firstName;
    @NotEmpty(message = "Last Name is required")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Phone Number is required")
    @Size(min = 10, max = 15, message = "Phone Number should be between 10 and 15 characters")
    private String phoneNumber;
    @NotEmpty(message = "Username is required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    private String username;
    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password should be at least 6 characters")
    private String password;
    
    public UserModel(Long userID, @NotEmpty(message = "First Name is required") String firstName,
			@NotEmpty(message = "Last Name is required") String lastName,
			@NotEmpty(message = "Email is required") @Email(message = "Email should be valid") String email,
			@NotEmpty(message = "Phone Number is required") @Size(min = 10, max = 15, message = "Phone Number should be between 10 and 15 characters") String phoneNumber,
			@NotEmpty(message = "Username is required") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
			@NotEmpty(message = "Password is required") @Size(min = 6, message = "Password should be at least 6 characters") String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}

	// Getters and Setters

    public UserModel() {
	}

	public Long getUserID() {
        return userID;
    }

    public void setUserID(Long id) {
        this.userID = id;
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
}
