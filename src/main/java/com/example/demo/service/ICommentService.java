package com.example.demo.service;

import com.example.demo.pojo.Comment;

import java.util.List;

public interface ICommentService {
	
	//闁哄被鍎撮锟�
	public Comment getCommentById(int CommentId);
	
	public List<Comment> getCommentByGoodId(int comment_goodid);
	
	//婵烇綀顕ф慨锟�
	public int addComment(Comment comment);
	
	//濞ｅ浂鍠楅弫锟�
	public int updateComment(Comment comment);
	
	//闁告帞濞�濞咃拷
	public int deleteComment(int id);
	
	//闁圭鎷烽柡鍫濐槺閺併倝骞嬮敓锟�
	public List<Comment> selectallComment(Comment comment);
	
	public List<Comment> selectMaxComment(Comment comment);
	
	public List<Comment> selectAllCommentStatus(Integer comment_status);
	
	public List<Comment> selectCommentBusiness(Integer bid);


	public  List<Comment> selectCommentBusinessBybid(Integer bid);

	Comment selectCommentById(Integer id);
}
