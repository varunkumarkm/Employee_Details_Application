package com.example.EmployeeDetails.Entitiy;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 45)
	private String firstName;
	
	@Column(nullable = false, length = 45)
	private String lastName;
	
	@Column(nullable = true, length=45)
	private String email;
	
	@Column(nullable = false)
	private String gender; 
	
	@Column(nullable = false, length = 45)
	private String designation;
	
	@Column(nullable = false)
	private int salary;
	
	@Column(nullable = true)
	private Date dateOfJoining;
	
	@Column(nullable = false)
	private String city;
	
	@Column (length = 10,unique = true)
	private long mobile;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", designation=" + designation + ", salary=" + salary + ", dateOfJoining="
				+ dateOfJoining + ", city=" + city + ", mobile=" + mobile + "]";
	}

	public Employee(long id, String firstName, String lastName, String email, String gender, String designation,
			int salary, Date dateOfJoining, String city, long mobile) {
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
