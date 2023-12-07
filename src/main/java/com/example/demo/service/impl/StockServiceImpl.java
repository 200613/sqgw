package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.StockMapper;
import com.example.demo.pojo.Stock;
import com.example.demo.service.IStockService;

@Service("StockService")
public class StockServiceImpl implements IStockService{

	@Resource
	private StockMapper StockDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.StockDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Stock record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Stock record) {
		// TODO Auto-generated method stub
		return this.StockDao.insertSelective(record);
	}

	@Override
	public Stock selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.StockDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Stock record) {
		// TODO Auto-generated method stub
		return this.StockDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Stock record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Stock> selectStock() {
		// TODO Auto-generated method stub
		return this.StockDao.selectStock();
	}

	@Override
	public List<Stock> selectStockByPid(Integer pid) {
		// TODO Auto-generated method stub
		return this.StockDao.selectStockByPid(pid);
	}

	@Override
	public List<Stock> selectStockByPidTime(Integer pid) {
		return this.StockDao.selectStockByPidTime(pid);
	}

}
