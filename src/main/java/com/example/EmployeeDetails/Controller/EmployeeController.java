package com.example.EmployeeDetails.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeDetails.Payload.EmployeeDTO;
import com.example.EmployeeDetails.Payload.EmployeeResponse;
import com.example.EmployeeDetails.Service.EmployeeService;
import com.example.EmployeeDetails.Utils.AppConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
	private EmployeeService employeeService;
	
/*	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
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
	}   */
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO  employeeDto){
	return new ResponseEntity<EmployeeDTO>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);  	
    }
    
    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees(){
    	return employeeService.getAllEmployees();
    }
    
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long id){
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDto, @PathVariable long id){
    	EmployeeDTO dto = employeeService.updateEmployee(employeeDto, id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
    	employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>("Employee entity is deleted successfully", HttpStatus.OK) ;
    	
    }
    //Pagination 
    @GetMapping("/employeePagination")
    public EmployeeResponse getEmployeesPagination(
    	//RequestParam will read the value from url
    	@RequestParam (value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
    	@RequestParam (value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
    	//localhost:8080/api/employees/employeePagination?pageNo=0&pageSize=05&sortBy=filedName
    	@RequestParam (value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,	
    	//localhost:8080/api/employees/employeePagination?pageNo=0&pageSize=05&sortBy=filedName&sortDir=desc
    	@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    	){
    	return employeeService.getEmployeesPagination(pageNo, pageSize, sortBy, sortDir);
    	}
    }

























