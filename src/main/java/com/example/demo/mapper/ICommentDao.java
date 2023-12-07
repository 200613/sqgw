package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Comment;

public interface ICommentDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectAllComment(Comment ccomment);

    List<Comment> selectgetgoodid(Integer comment_goodid);

    Comment findByCommentname(String Commentname);

    int updateIsComment(Comment record);

    List<Comment> selectMaxComment(Comment ccomment);

    List<Comment> selectCommentBusinessBybid(Integer bid);

    List<Comment> selectAllCommentStatus(Integer comment_status);

    List<Comment> selectCommentBusiness(Integer bid);

    Comment selectCommentById(Integer id);



}
