package com.example.EmployeeDetails.Payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	
	@NotNull
	@Size(min = 2, message = "Comment Body should be hav atleast 2 character")
	private String body;
	private String email;
	private String name;
	
	
}
