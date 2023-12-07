package com.example.demo.service;

import com.example.demo.pojo.Lun;

import java.util.List;

public interface ILunService {
	   int deleteByPrimaryKey(Integer id);

	    int insert(Lun record);

	    int insertSelective(Lun record);

	    Lun selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Lun record);

	    int updateByPrimaryKey(Lun record);
	    
	    List<Lun> selectLun();
}
