package com.example.EmployeeDetails.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeDetails.Entitiy.Employee;
import com.example.EmployeeDetails.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id){
		Optional<Employee> employeeById = employeeService.getEmployeeById(id);
		return employeeById;
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id){
		employeeService.updateEmployee(employee, id);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deletePost(@PathVariable long id){
		employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee entity deleted successfully",HttpStatus.OK);
	}
}
























