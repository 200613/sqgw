package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Cform;


public interface ICformDao {



    int insert(Cform record);



    List<Cform> selectByorderid(String order_id);


    List<Cform> selectByPrimaryKeyGood(Integer form_goodid);

    List<Cform> selectallCform(Cform cform);

    int deleteRepeatCform();

    Cform selectByCformid(String order_id);


    List<Cform> selectByGoodNum(@Param("form_goodid")Integer form_goodid,@Param("order_id")String order_id);
}
