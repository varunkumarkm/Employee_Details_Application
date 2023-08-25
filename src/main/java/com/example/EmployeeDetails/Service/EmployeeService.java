package com.example.EmployeeDetails.Service;

import java.util.List;
import com.example.EmployeeDetails.Payload.EmployeeDTO;
import com.example.EmployeeDetails.Payload.EmployeeResponse;

import jakarta.validation.Valid;

public interface EmployeeService {

/*	public void save(Employee employee);

	public List<Employee> getAllEmployees();

	public void updateEmployee(Employee employee, long id);

	public void deleteEmployee(long id);

	public Optional<Employee> getEmployeeById(long id); */
	
//-----------------------------------------------------------------------
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto);

	public List<EmployeeDTO> getAllEmployees();

	public EmployeeDTO getEmployeeById(long id);

	public EmployeeDTO updateEmployee(@Valid EmployeeDTO employeeDto, long id);

	public void deleteEmployeeById(long id);

	EmployeeResponse getEmployeesPagination(int pageNo, int pageSize, String sortBy, String sortDir);
	
}
