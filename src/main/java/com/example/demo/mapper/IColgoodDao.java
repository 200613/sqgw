package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Colgood;

public interface IColgoodDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Colgood record);

    int insertSelective(Colgood record);

    Colgood selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Colgood record);

    int updateByPrimaryKey(Colgood record);

    List<Colgood> selectColgoodByOpenid(String openid);

    Colgood selectColgoodByOpenidGid(@Param("openid")String openid,@Param("gid")Integer gid);
}