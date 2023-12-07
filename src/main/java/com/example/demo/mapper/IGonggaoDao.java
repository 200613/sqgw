package com.example.demo.mapper;

import com.example.demo.pojo.Gonggao;

import java.util.List;


public interface IGonggaoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Gonggao record);

    int insertSelective(Gonggao record);

    Gonggao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gonggao record);

    int updateByPrimaryKey(Gonggao record);
    
    List<Gonggao> selectGonggao();
}