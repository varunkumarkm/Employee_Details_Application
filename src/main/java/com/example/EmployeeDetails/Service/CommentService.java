package com.example.EmployeeDetails.Service;

import java.util.List;
import com.example.EmployeeDetails.Payload.CommentDto;

public interface CommentService {

	public CommentDto createComment(long employeeId, CommentDto commentDto);
	public List<CommentDto> getCommentByEmployeeId(long employeeId);
	public CommentDto updateComment(long employeeId, long commentId, CommentDto commentDto);
	public void deleteComment(long employeeId, long commentId);
}
