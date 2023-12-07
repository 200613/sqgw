/**
 *
 */
package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Customer;


public interface ICustomerService {

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectCustomerByOpenid(String openid);

    Customer checklogin( @Param("name")String name, @Param("pwd")String pwd);

    List<Customer> selectCustomer();
}
