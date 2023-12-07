package com.example.demo.service;

import com.example.demo.pojo.Ifc;

import java.util.List;

public interface IIfcService {
    int deleteByPrimaryKey(Integer id);

    int insert(Ifc record);

    int insertSelective(Ifc record);

    Ifc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ifc record);

    int updateByPrimaryKey(Ifc record);
    
    List<Ifc> selectIfc();
}
