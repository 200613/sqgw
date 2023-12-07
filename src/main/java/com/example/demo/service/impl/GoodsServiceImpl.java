package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IGoodsDao;
import com.example.demo.pojo.Goods;
import com.example.demo.service.IGoodsService;

@Service("GoodsService")
public class GoodsServiceImpl implements IGoodsService{

    @Resource
    private IGoodsDao GoodsDao;

    @Override
    public int insertGoods(Goods busfoos) {
        // TODO Auto-generated method stub
        return this.GoodsDao.insertGoods(busfoos);
    }


    @Override
    public Goods selectGoodsBygoodid(Integer id) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsBygoodid(id);
    }

    @Override
    public int updateGoods(Goods Goods) {
        // TODO Auto-generated method stub
        return this.GoodsDao.updateGoods(Goods);
    }

    @Override
    public List<Goods> selectGoodsByfname(String fname) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsByfname(fname);
    }


    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.GoodsDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Goods> selectAllGoods(Goods Goods) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectAllGoods(Goods);
    }

    @Override
    public List<Goods> selectGoodsByifc(String ifc) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsByifc(ifc);
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsById(id);
    }

    @Override
    public List<Goods> selectAllGoodsByifc(String foodifc) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectAllGoodsByifc(foodifc);
    }


    @Override
    public int updateGoodsByStatus(Goods Goods) {
        // TODO Auto-generated method stub
        return this.GoodsDao.updateGoodsByStatus(Goods);
    }

    @Override
    public int updateGoodsById(Goods Goods) {
        // TODO Auto-generated method stub
        return this.GoodsDao.updateGoodsById(Goods);
    }


    @Override
    public List<Goods> selectAllGoodsByBid(String ifc) {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsByifc(ifc);
    }


    @Override
    public List<Goods> selectGoodsByFsales() {
        // TODO Auto-generated method stub
        return this.GoodsDao.selectGoodsByFsales();
    }


    @Override
    public int updateByPrimaryKeySelective(Goods Goods) {
        // TODO Auto-generated method stub
        return this.GoodsDao.updateByPrimaryKeySelective(Goods);
    }

    @Override
    public List<Goods> selectGoodsBySid(Integer sid) {
        return this.GoodsDao.selectGoodsBySid(sid);
    }

}
