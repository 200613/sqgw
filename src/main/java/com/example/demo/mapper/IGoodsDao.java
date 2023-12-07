package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.Goods;

public interface IGoodsDao {

    int insertGoods(Goods Goods);

    Goods selectGoodsBygoodid(Integer id);

    int updateGoods(Goods Goods);

    List<Goods> selectGoodsByfname(String fname);

    int deleteByPrimaryKey(Integer id);

    List<Goods> selectAllGoods(Goods Goods);

    List<Goods> selectGoodsByifc(String ifc);

    Goods selectGoodsById(Integer id);

    List<Goods> selectAllGoodsByifc(String foodifc);

    int updateGoodsByStatus(Goods Goods);

    int updateGoodsById(Goods Goods);

    List<Goods> selectGoodsByFsales();

    int updateByPrimaryKeySelective(Goods Goods);

    List<Goods> selectGoodsBySid(Integer sid);

}
