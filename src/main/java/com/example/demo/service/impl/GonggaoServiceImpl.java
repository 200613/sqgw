package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.mapper.IGonggaoDao;
import com.example.demo.pojo.Gonggao;
import com.example.demo.service.IGonggaoService;
import org.springframework.stereotype.Service;


@Service("GonggaoService")
public class GonggaoServiceImpl implements IGonggaoService {

	@Resource
	private IGonggaoDao GonggaoDao;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.GonggaoDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Gonggao record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Gonggao record) {
		// TODO Auto-generated method stub
		return this.GonggaoDao.insertSelective(record);
	}

	@Override
	public Gonggao selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.GonggaoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Gonggao record) {
		// TODO Auto-generated method stub
		return this.GonggaoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Gonggao record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Gonggao> selectGonggao() {
		// TODO Auto-generated method stub
		return this.GonggaoDao.selectGonggao();
	}

}
