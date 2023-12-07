package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IColgoodDao;
import com.example.demo.pojo.Colgood;
import com.example.demo.service.IColgoodService;

@Service("ColgoodService")
public class ColgoodServiceImpl implements IColgoodService{

    @Resource
    private IColgoodDao ColgoodDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Colgood record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(Colgood record) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.insertSelective(record);
    }

    @Override
    public Colgood selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Colgood record) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Colgood record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Colgood> selectColgoodByOpenid(String openid) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.selectColgoodByOpenid(openid);
    }

    @Override
    public Colgood selectColgoodByOpenidGid(String openid, Integer gid) {
        // TODO Auto-generated method stub
        return this.ColgoodDao.selectColgoodByOpenidGid(openid, gid);
    }

}
