/**
 *
 */
package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Order;



/**
 * @author WXF
 * @date 下午1:36:25
 * @address 常州
 */
public interface IOrderService {

    List<Order> selectByOrderid(String order_id);

    public List<Order> selectByPrimaryKeyOpenid(String order_openid);

    public int insert(Order order);

    public int deleteByPrimaryKey(Integer id);

    public int updateIsorderIspay(Order order);

    public int updateIsorderIsstatus(Order order);

    public Order selectByPrimaryKey(Integer id);

    public List<Order> selectBybid(Integer bid);

    public List<Order> selectByPrimaryKeyOpenidStatus(@Param("order_openid")String order_openid,@Param("order_status")Integer order_status);

    public List<Order> selectallOrder();

}
