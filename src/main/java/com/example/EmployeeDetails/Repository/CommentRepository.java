package com.example.EmployeeDetails.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeDetails.Entitiy.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	//Custom methods, which will help us to find the any column, we want to use this because we need to take 
	//some other column other than id
	//Ex: we find the email List<Comment> findByEmail(String email);
	//we find the mobile number, Comment findByMobile(long mobile); Because mobile number are unique
	
	List<Comment> findByEmployeeId(long employeeId);

}
