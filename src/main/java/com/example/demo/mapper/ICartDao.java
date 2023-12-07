package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Cart;

public interface ICartDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);


    int deleteByCartGoodid(@Param("cart_goodid")Integer cart_goodid,@Param("cart_openid")String cart_openid);

    int insertSelective(Cart record);

    List<Cart> selectByPrimaryKey(String cart_openid);

    int updateByPrimaryKeySelective(Cart record);

    int updategoodcart(Cart cart);

    List<Cart> selectAllCart(Cart record);

    Cart selectgoodCart(@Param("cart_goodid")Integer cart_goodid,@Param("cart_openid")String cart_openid);

    Cart findBycart(@Param("cart_goodid")Integer cart_goodid,@Param("cart_openid")String cart_openid);

}
