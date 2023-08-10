package com.example.EmployeeDetails.Controller;

import java.util.List;
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
import com.example.EmployeeDetails.Entitiy.EmployeeDTO;
import com.example.EmployeeDetails.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setGender(employee.getGender());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setSalary(employee.getSalary());
		employeeDTO.setDateOfJoining(employee.getDateOfJoining());
		employeeDTO.setCity(employee.getCity());
		employeeDTO.setMobile(employee.getMobile());
		
		employeeService.save(employee);
		
		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(Employee employee){
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee employee){
        
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setGender(employee.getGender());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setSalary(employee.getSalary());
		employeeDTO.setDateOfJoining(employee.getDateOfJoining());
		employeeDTO.setCity(employee.getCity());
		employeeDTO.setMobile(employee.getMobile());
		
		employeeService.updateEmployee(employee);
		return new ResponseEntity<EmployeeDTO>(employeeDTO, HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deletePost(@PathVariable long id){
		employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee entity deleted successfully",HttpStatus.OK);
	}
}
























