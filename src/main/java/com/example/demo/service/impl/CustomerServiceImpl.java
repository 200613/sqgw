package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ICustomerDao;
import com.example.demo.pojo.Customer;
import com.example.demo.service.ICustomerService;

@Service(value = "customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Resource
    private ICustomerDao customerdao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.customerdao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Customer record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(Customer record) {
        // TODO Auto-generated method stub
        return this.customerdao.insertSelective(record);
    }

    @Override
    public Customer selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return this.customerdao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        // TODO Auto-generated method stub
        return this.customerdao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Customer selectCustomerByOpenid(String openid) {
        // TODO Auto-generated method stub
        return this.customerdao.selectCustomerByOpenid(openid);
    }

    @Override
    public Customer checklogin(String name, String pwd) {
        // TODO Auto-generated method stub
        return this.customerdao.checklogin(name, pwd);
    }

    @Override
    public List<Customer> selectCustomer() {
        // TODO Auto-generated method stub
        return this.customerdao.selectCustomer();
    }

}
