package com.example.EmployeeDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EmployeeDetails.Entitiy.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
