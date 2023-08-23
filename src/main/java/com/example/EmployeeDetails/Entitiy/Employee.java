package com.example.EmployeeDetails.Entitiy;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", designation=" + designation + ", salary=" + salary + ", dateOfJoining="
				+ dateOfJoining + ", city=" + city + ", mobile=" + mobile + "]";
	}
	public Employee(long id, String firstName, String lastName, String email, String gender, String designation,
			int salary, Date dateOfJoining, String city, String mobile) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.designation = designation;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
		this.city = city;
		this.mobile = mobile;
	}
	public Employee() {
		super();
	}
}
