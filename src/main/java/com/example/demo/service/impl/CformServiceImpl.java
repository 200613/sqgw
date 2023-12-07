package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ICformDao;
import com.example.demo.pojo.Cform;
import com.example.demo.service.ICformService;


@Service("CformService")
public class CformServiceImpl implements ICformService{

    @Resource
    private ICformDao cformDao;

    @Override
    public List<Cform> getcformById(Integer form_goodid) {
        // TODO Auto-generated method stub
        return this.cformDao.selectByPrimaryKeyGood(form_goodid);
    }

    @Override
    public int addcform(Cform cform) {
        // TODO Auto-generated method stub
        return this.cformDao.insert(cform);
    }

    @Override
    public List<Cform> selectgetcform(String order_id) {
        // TODO Auto-generated method stub
        return this.cformDao.selectByorderid(order_id);
    }

    @Override
    public List<Cform> selectallCform(Cform cform) {
        // TODO Auto-generated method stub
        return this.cformDao.selectallCform(cform);
    }

    @Override
    public int deleteRepeatCform() {
        // TODO Auto-generated method stub
        return this.cformDao.deleteRepeatCform();
    }

    @Override
    public Cform selectByCformid(String order_id) {
        // TODO Auto-generated method stub
        return this.cformDao.selectByCformid(order_id);
    }


}
