package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ILunDao;
import com.example.demo.pojo.Lun;
import com.example.demo.service.ILunService;

@Service("LunService")
public class LunServiceImpl implements ILunService{

    @Resource
    private ILunDao LunDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.LunDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Lun record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(Lun record) {
        // TODO Auto-generated method stub
        return this.LunDao.insertSelective(record);
    }

    @Override
    public Lun selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.LunDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Lun record) {
        // TODO Auto-generated method stub
        return this.LunDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Lun record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Lun> selectLun() {
        // TODO Auto-generated method stub
        return this.LunDao.selectLun();
    }


}
