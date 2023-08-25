package com.example.EmployeeDetails.Entitiy;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=2, max=30)
	@Column(nullable = false, length = 45)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=30)
	@Column(nullable = false, length = 45)
	private String lastName;
	
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Invalid email format" )
	@Column(nullable = true, length=45)
	private String email;
	
	@NotNull
	@Size(min=2, max=10)
	@Column(nullable = false)
	private String gender; 
	
	@NotNull
	@Size(min=2, max=30)
	@Column(nullable = false, length = 45)
	private String designation;
	
	@NotNull
	@Column(nullable = false)
	private int salary;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(nullable = true)
	private Date dateOfJoining;
	
	@NotNull
	@Size(min=5, max=45)
	@Column(nullable = false)
	private String city;
	
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number format")
	private String mobile;
    
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)// OneToMany and ManyToOne is a bi-directional mapping
    Set<Comment> comments = new HashSet<>();

}