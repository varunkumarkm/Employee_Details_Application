package com.example.EmployeeDetails.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeDetails.Entitiy.Employee;
import com.example.EmployeeDetails.Entitiy.EmployeeDTO;
import com.example.EmployeeDetails.Repository.EmployeeRepository;
import com.example.EmployeeDetails.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> getEmployees = employeeRepo.findAll();
		return getEmployees;
	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	@Override
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}
	
}
