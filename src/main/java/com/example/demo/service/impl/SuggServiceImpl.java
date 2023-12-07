package com.example.demo.service.impl;

import com.example.demo.mapper.ISuggDao;
import com.example.demo.pojo.Sugg;
import com.example.demo.service.ISuggService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SuggService")
public class SuggServiceImpl implements ISuggService{

	@Resource
	private ISuggDao SuggDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.SuggDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Sugg record) {
		// TODO Auto-generated method stub
		return this.SuggDao.insert(record);
	}

	@Override
	public int insertSelective(Sugg record) {
		// TODO Auto-generated method stub
		return this.SuggDao.insertSelective(record);
	}

	@Override
	public Sugg selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.SuggDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Sugg record) {
		// TODO Auto-generated method stub
		return this.SuggDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Sugg record) {
		// TODO Auto-generated method stub
		return this.SuggDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Sugg> selectSugg() {
		// TODO Auto-generated method stub
		return this.SuggDao.selectSugg();
	}

	@Override
	public List<Sugg> selectSuggByOpenid(String openid) {
		// TODO Auto-generated method stub
		return this.SuggDao.selectSuggByOpenid(openid);
	}

}
