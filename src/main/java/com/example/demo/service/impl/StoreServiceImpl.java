package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IStoreDao;
import com.example.demo.pojo.Store;
import com.example.demo.service.IStoreService;

@Service("StoreService")
public class StoreServiceImpl implements IStoreService{

	@Resource
	private IStoreDao StoreDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.StoreDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Store record) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	@Override
	public int insertSelective(Store record) {
		// TODO Auto-generated method stub
		return this.StoreDao.insertSelective(record);
	}

	@Override
	public Store selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.StoreDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Store record) {
		// TODO Auto-generated method stub
		return this.StoreDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Store record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Store> selectStore() {
		// TODO Auto-generated method stub
		return this.StoreDao.selectStore();
	}

	@Override
	public Store selectStoreByNamePwd(String name, String pwd) {
		// TODO Auto-generated method stub
		return this.StoreDao.selectStoreByNamePwd(name, pwd);
	}

}
