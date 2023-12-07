package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Goods;

public interface IGoodsService {

    public int insertGoods(Goods busfoos);

    public List<Goods> selectAllGoodsByBid(String ifc);

    public Goods selectGoodsBygoodid(Integer id);

    public int updateGoods(Goods Goods);

    public List<Goods> selectGoodsByfname(String fname);

    public int deleteByPrimaryKey(Integer id);

    public List<Goods> selectAllGoods(Goods Goods);

    public List<Goods> selectGoodsByifc(String ifc);

    public Goods selectGoodsById(Integer id);

    public List<Goods> selectAllGoodsByifc(String foodifc);

    int updateGoodsByStatus(Goods Goods);

    int updateGoodsById(Goods Goods);

    List<Goods> selectGoodsByFsales();

    int updateByPrimaryKeySelective(Goods Goods);

    List<Goods> selectGoodsBySid(Integer sid);
}
