package com.example.demo.service;

import com.example.demo.pojo.Sugg;

import java.util.List;

public interface ISuggService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Sugg record);

    int insertSelective(Sugg record);

    Sugg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sugg record);

    int updateByPrimaryKey(Sugg record);
    
    List<Sugg> selectSugg();
    
    List<Sugg> selectSuggByOpenid(String openid);

}
