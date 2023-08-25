package com.example.EmployeeDetails.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {

	private long id;
	private String body;
	private String email;
	private String name;
	
	
}
