package com.example.EmployeeDetails.Service;

import java.util.List;
import com.example.EmployeeDetails.Entitiy.Employee;

public interface EmployeeService {

	public void save(Employee employee);

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee);

	public void deleteEmployee(long id);
	
}
