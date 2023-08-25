package com.example.EmployeeDetails.Payload;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender; 
	private String designation;
	private int salary;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date dateOfJoining;
	private String city;
	private String mobile;
}















