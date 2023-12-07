/**
 * 
 */
package com.example.demo.service;

import com.example.demo.pojo.Address;

import java.util.List;

/**
 * @author WXF
 * @date 下午12:25:45
 * @address 常州
 */
public interface IAddressService {
	//查询
		public List<Address> getAddressById(String address_openid);
		
		//添加
		public int addAddress(Address address);
		
		public int updateAddressstatus(Address address);
		
		public int updategetAddress(Address address);
		
		public Address getaddress(String address_openid);
		
		//修改
		public int updateAddress(Address address);
		
		//删除
		public int deleteAddress(int id);
		
		//所有用户
		public List<Address> selectallAddress(Address address);
		
		public  Address getaddressByid(Integer id);

		public  int updateAddressByid(Address address);
}
