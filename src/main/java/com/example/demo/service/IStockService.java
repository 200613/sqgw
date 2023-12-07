package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Stock;

public interface IStockService {
	int deleteByPrimaryKey(Integer id);

	int insert(Stock record);

	int insertSelective(Stock record);

	Stock selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Stock record);

	int updateByPrimaryKey(Stock record);

	List<Stock> selectStock();

	List<Stock> selectStockByPid(Integer pid);

	List<Stock> selectStockByPidTime(Integer pid);
}
