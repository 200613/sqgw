/**
 *
 */
package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Order;


/**
 * @author WXF
 * @date 上午11:15:07
 * @address 常州
 */
public interface IOrderDao {



    List<Order> selectByOrderid(String order_id);

    List<Order> selectByPrimaryKeyOpenid(String order_openid);

    List<Order> selectallOrder();

    int insert(Order order);

    int deleteByPrimaryKey(Integer id);

    int updateIsorderIspay(Order order);

    int updateIsorderIsstatus(Order order);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectByPrimaryKeyOpenid(@Param("cus_id")String cus_id,@Param("order_status")Integer order_status);

    List<Order> selectBybid(Integer bid);

    List<Order> selectByPrimaryKeyOpenidStatus(@Param("order_openid")String order_openid,@Param("order_status")Integer order_status);

}
