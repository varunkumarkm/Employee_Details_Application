package com.example.EmployeeDetails.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeDetails.Entitiy.Comment;
import com.example.EmployeeDetails.Entitiy.Employee;
import com.example.EmployeeDetails.Exception.ResourceNotFoundException;
import com.example.EmployeeDetails.Payload.CommentDto;
import com.example.EmployeeDetails.Repository.CommentRepository;
import com.example.EmployeeDetails.Repository.EmployeeRepository;
import com.example.EmployeeDetails.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private EmployeeRepository employeeRepo; 

	@Override
	public CommentDto createComment(long employeeId, CommentDto commentDto) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("employee", "id", employeeId)
				);
		Comment comment = mapToComment(commentDto);
		comment.setEmployee(employee);
		Comment newComment = commentRepo.save(comment);
		return mapToDto(newComment);
	}
	
	@Override
	public List<CommentDto> getCommentByEmployeeId(long employeeId) {
		List<Comment> comments = commentRepo.findByEmployeeId(employeeId);
		return comments.stream().map(comment->mapToDto(comment)).collect(Collectors.toList());
	}
	
	@Override
	public CommentDto updateComment(long employeeId, long commentId, CommentDto commentDto) {
		employeeRepo.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("employee", "id", employeeId)
				);
		
		Comment comment = commentRepo.findById(commentId).orElseThrow(
				()-> new ResourceNotFoundException("comment", "commentId", commentId)
				);
		
		comment.setBody(commentDto.getBody());
		comment.setEmail(commentDto.getEmail());
		comment.setName(commentDto.getName());
		
		Comment updatedComment = commentRepo.save(comment);
		return mapToDto(updatedComment);
	}

	@Override
	public void deleteComment(long employeeId, long commentId) {
		employeeRepo.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("employee", "id", employeeId)
				);
		
		commentRepo.findById(commentId).orElseThrow(
				()-> new ResourceNotFoundException("commentId", "id", commentId)
				);
		
		commentRepo.deleteById(commentId);
	}
	
	private Comment mapToComment(CommentDto commentDto) {
		
		Comment comment = new Comment();
		
		comment.setBody(commentDto.getBody());
		comment.setEmail(commentDto.getEmail());
		comment.setName(commentDto.getName());
		return comment;
	}
	private CommentDto mapToDto(Comment comment) {
		
		CommentDto commentDto = new CommentDto();
		
		commentDto.setId(comment.getId());
		commentDto.setBody(comment.getBody());
		commentDto.setEmail(comment.getEmail());
		commentDto.setName(comment.getName());
		return commentDto;
		
	}
}







