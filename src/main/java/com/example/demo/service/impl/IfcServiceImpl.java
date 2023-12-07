package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IIfcDao;
import com.example.demo.pojo.Ifc;
import com.example.demo.service.IIfcService;

@Service("IfcService")
public class IfcServiceImpl implements IIfcService{

    @Resource
    private IIfcDao IfcDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.IfcDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Ifc record) {
        // TODO Auto-generated method stub
        return this.IfcDao.insert(record);
    }

    @Override
    public int insertSelective(Ifc record) {
        // TODO Auto-generated method stub
        return this.IfcDao.insertSelective(record);
    }

    @Override
    public Ifc selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.IfcDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Ifc record) {
        // TODO Auto-generated method stub
        return this.IfcDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ifc record) {
        // TODO Auto-generated method stub
        return this.IfcDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Ifc> selectIfc() {
        // TODO Auto-generated method stub
        return this.IfcDao.selectIfc();
    }

}
