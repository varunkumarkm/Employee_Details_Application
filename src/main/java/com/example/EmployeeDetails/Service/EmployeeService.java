package com.example.EmployeeDetails.Service;

import java.util.List;
import java.util.Optional;

import com.example.EmployeeDetails.Entitiy.Employee;

public interface EmployeeService {

	public void save(Employee employee);

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee, long id);

	public void deleteEmployee(long id);

	public Optional<Employee> getEmployeeById(long id);
	
}
