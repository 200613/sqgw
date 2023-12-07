package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IOrderDao;
import com.example.demo.pojo.Order;
import com.example.demo.service.IOrderService;

@Service("OrderService")
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderDao orderDao;

    @Override
    public List<Order> selectByOrderid(String order_id) {
        // TODO Auto-generated method stub
        return this.orderDao.selectByOrderid(order_id);
    }

    @Override
    public List<Order> selectByPrimaryKeyOpenid(String order_openid) {
        // TODO Auto-generated method stub
        return this.orderDao.selectByPrimaryKeyOpenid(order_openid);
    }

    @Override
    public int insert(Order order) {
        // TODO Auto-generated method stub
        return this.orderDao.insert(order);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.orderDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateIsorderIspay(Order order) {
        // TODO Auto-generated method stub
        return this.orderDao.updateIsorderIspay(order);
    }

    @Override
    public int updateIsorderIsstatus(Order order) {
        // TODO Auto-generated method stub
        return this.orderDao.updateIsorderIsstatus(order);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.orderDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> selectBybid(Integer bid) {
        // TODO Auto-generated method stub
        return this.orderDao.selectBybid(bid);
    }

    @Override
    public List<Order> selectByPrimaryKeyOpenidStatus(String order_openid, Integer order_status) {
        // TODO Auto-generated method stub
        return this.orderDao.selectByPrimaryKeyOpenidStatus(order_openid, order_status);
    }

    @Override
    public List<Order> selectallOrder() {
        // TODO Auto-generated method stub
        return this.orderDao.selectallOrder();
    }


}
