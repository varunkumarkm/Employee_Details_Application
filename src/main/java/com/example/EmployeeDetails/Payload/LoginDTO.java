package com.example.EmployeeDetails.Payload;

import lombok.Data;

@Data
public class LoginDTO {

	private String usernameOrEmail;
	private String password;
}
