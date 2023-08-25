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
import com.example.EmployeeDetails.Payload.CommentDto;
import com.example.EmployeeDetails.Service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	//localhost:8080/api/employees/0/comments
	@PostMapping("employees/{employeeId}/comments")
	public ResponseEntity<CommentDto> createComment(@PathVariable long employeeId, @RequestBody CommentDto commentDto){
		CommentDto dto = commentService.createComment(employeeId, commentDto);
		return new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
	}
	
	//localhost:8080/api/employees/0/getAllEmployeeComments
	@GetMapping("employees/{employeeId}/getEmployeeComments")
	public List<CommentDto> getAllCommentsByEmployeeId(@PathVariable long employeeId) {
		List<CommentDto> dto = commentService.getCommentByEmployeeId(employeeId);
		return dto;
	}
	
	//localhost:8080/api/employees/id/updateComment/id
	@PutMapping("employees/{employeeId}/updateComment/{commentId}")
	public ResponseEntity<CommentDto> updateComment(
			@PathVariable long employeeId, 
			@PathVariable long commentId,
			@RequestBody CommentDto commentDto){
		CommentDto dto = commentService.updateComment(employeeId, commentId, commentDto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	//localhost:8080/api/employees/id/deleteComment/id
	@DeleteMapping("employees/{employeeId}/deleteComment/{commentId}")
	public ResponseEntity<String> deleteComment(
			@PathVariable long employeeId, 
			@PathVariable long commentId){
		commentService.deleteComment(employeeId, commentId);
		return new ResponseEntity<>("Comment is deleted successfully", HttpStatus.OK) ;
			
   }
}








