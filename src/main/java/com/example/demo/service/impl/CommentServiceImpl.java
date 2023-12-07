package com.example.demo.service.impl;

import com.example.demo.mapper.ICommentDao;
import com.example.demo.pojo.Comment;
import com.example.demo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("comentService")
public class CommentServiceImpl implements ICommentService {

	
	@Autowired
	private ICommentDao commentDao;
	
	@Override
	public Comment getCommentById(int CommentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.insert(comment);
	}

	@Override
	public int updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.updateIsComment(comment);
	}

	@Override
	public int deleteComment(int id) {
		// TODO Auto-generated method stub
		return this.commentDao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Comment> selectallComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.selectAllComment(comment);
	}

	@Override
	public List<Comment> getCommentByGoodId(int comment_goodid) {
		// TODO Auto-generated method stub
		return this.commentDao.selectgetgoodid(comment_goodid);
	}

	@Override
	public List<Comment> selectMaxComment(Comment comment) {
		// TODO Auto-generated method stub
		return this.commentDao.selectMaxComment(comment);
	}

	@Override
	public List<Comment> selectAllCommentStatus(Integer comment_status) {
		// TODO Auto-generated method stub
		return this.commentDao.selectAllCommentStatus(comment_status);
	}

	@Override
	public List<Comment> selectCommentBusiness(Integer bid) {
		// TODO Auto-generated method stub
		return this.commentDao.selectCommentBusiness(bid);
	}



	@Override
	public List<Comment> selectCommentBusinessBybid(Integer bid) {
		// TODO Auto-generated method stub
		return this.commentDao.selectCommentBusinessBybid(bid);
	}

	@Override
	public Comment selectCommentById(Integer id) {
		return this.commentDao.selectCommentById(id);
	}

}
