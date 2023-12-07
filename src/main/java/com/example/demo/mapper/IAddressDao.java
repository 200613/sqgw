/**
 *
 */
package com.example.demo.mapper;

import java.util.List;

import com.example.demo.pojo.Address;



/**
 * @author WXF
 * @date 下午12:20:22
 * @address 常州
 */
public interface IAddressDao {

    int deleteByPrimaryKey(Integer id);

    Address getaddress(String address_openid);

    int insert(Address record);

    int updateAddressstatus(Address address);

    int updateAddress(Address address);

    int insertSelective(Address record);

    List<Address> selectByPrimaryKey(String address_openid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAllAddress(Address record);

    Address getaddressByid(Integer id);

    int updateAddressByid(Address address);

}
