package com.example.EmployeeDetails.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.EmployeeDetails.Entitiy.Employee;
import com.example.EmployeeDetails.Exception.ResourceNotFoundException;
import com.example.EmployeeDetails.Payload.EmployeeDTO;
import com.example.EmployeeDetails.Payload.EmployeeResponse;
import com.example.EmployeeDetails.Repository.EmployeeRepository;
import com.example.EmployeeDetails.Service.EmployeeService;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	private ModelMapper mapper;
	
	public EmployeeServiceImpl(ModelMapper mapper) {
		this.mapper = mapper;
	}

/*	@Override
	public void save(Employee employee) {
		employeeRepo.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> getEmployees = employeeRepo.findAll();
		return getEmployees;
	}
	
	@Override
	public void updateEmployee(Employee employee, long id) {
		employeeRepo.save(employee);
		employeeRepo.findById(id);
	}
	
	@Override
	public void deleteEmployee(long id) {
		employeeRepo.deleteById(id);
	}
	
	@Override
	public Optional<Employee> getEmployeeById(long id) {
		Optional<Employee> employeeFindById = employeeRepo.findById(id);
		return employeeFindById;
	}  */
//--------------------------------------------------------------------------------------
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDto) {
		
		Employee employee =  mapToEntity(employeeDto);
		Employee employeeEntity = employeeRepo.save(employee);
		EmployeeDTO dto =  mapToDto(employeeEntity);
		return dto;
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		return employees.stream().map(employ -> mapToDto(employ)).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDTO getEmployeeById(long id) {
	    Employee employee = employeeRepo.findById(id).orElseThrow(
	    		()-> new ResourceNotFoundException("Employee", "id", id)
	    		);
	    EmployeeDTO employeeDto = mapToDto(employee);	
		return employeeDto;
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		employeeRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "id", id)
				);
		employeeRepo.deleteById(id);
	}
	
	@Override
	public EmployeeResponse getEmployeesPagination(int pageNo, int pageSize, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                    : Sort.by(sortBy).descending();
 
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Employee> employees = employeeRepo.findAll(pageable);
		List<Employee> content = employees.getContent();
		
		List<EmployeeDTO> contents = content.stream().map(employ -> mapToDto(employ)).collect(Collectors.toList());
	    
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setContent(contents);
		employeeResponse.setPageNo(employees.getNumber());
		employeeResponse.setPageSize(employees.getSize());
		employeeResponse.setTotalPages(employees.getTotalPages());
		employeeResponse.setTotalElements(employees.getTotalElements());
		employeeResponse.setLast(employees.isLast());
		
		return employeeResponse;	
	}
	
	@Override
	public EmployeeDTO updateEmployee(@Valid EmployeeDTO employeeDto, long id) {
		Employee employee = employeeRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "id", id)
				     );
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setGender(employeeDto.getGender());
		employee.setDesignation(employeeDto.getDesignation());
		employee.setSalary(employeeDto.getSalary());
		employee.setDateOfJoining(employeeDto.getDateOfJoining());
		employee.setCity(employeeDto.getCity());
		employee.setMobile(employeeDto.getMobile());
		
		Employee newEmployee = employeeRepo.save(employee);
		
		return mapToDto(newEmployee);
	}
	
	public Employee mapToEntity(EmployeeDTO employeeDto) {
		
		Employee employee = mapper.map(employeeDto, Employee.class);//It will automatically copy the data from DTO to Entity
		
//		Employee employee = new Employee();
//		
//		employee.setFirstName(employeeDto.getFirstName());
//		employee.setLastName(employeeDto.getLastName());
//		employee.setEmail(employeeDto.getEmail());
//		employee.setGender(employeeDto.getGender());
//		employee.setDesignation(employeeDto.getDesignation());
//		employee.setSalary(employeeDto.getSalary());
//		employee.setDateOfJoining(employeeDto.getDateOfJoining());
//		employee.setCity(employeeDto.getCity());
//		employee.setMobile(employeeDto.getMobile());
		
		return employee;
	}
	public EmployeeDTO mapToDto(Employee employee) {
		
		EmployeeDTO dto = mapper.map(employee, EmployeeDTO.class);//It will automatically copy the data from Entity to DTO 
		
//		EmployeeDTO dto = new EmployeeDTO();
//		
//		dto.setId(employee.getId());
//		dto.setFirstName(employee.getFirstName());
//		dto.setLastName(employee.getLastName());
//		dto.setEmail(employee.getEmail());
//		dto.setGender(employee.getGender());
//		dto.setDesignation(employee.getDesignation());
//		dto.setSalary(employee.getSalary());
//		dto.setDateOfJoining(employee.getDateOfJoining());
//		dto.setCity(employee.getCity());
//		dto.setMobile(employee.getMobile());
		
		return dto;	
	}
}



























