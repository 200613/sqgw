package com.example.demo.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Store;

public interface IStoreService {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
    
    List<Store> selectStore();
    
    Store selectStoreByNamePwd(@Param("name") String name, @Param("pwd") String pwd);
}
