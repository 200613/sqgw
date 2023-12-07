package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.IAddressDao;
import com.example.demo.pojo.Address;
import com.example.demo.service.IAddressService;

@Service("AddressService")
public class AddressServiceImpl implements IAddressService {
    @Resource
    private IAddressDao addressDao;
    @Override
    public List<Address> getAddressById(String address_openid) {
        // TODO Auto-generated method stub
        return this.addressDao.selectByPrimaryKey(address_openid);
    }
    /* (non-Javadoc)
     * @see com.example.demo.service.IAddressService#addAddress(com.example.demo.pojo.Address)
     */
    @Override
    public int addAddress(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.insert(address);
    }
    /* (non-Javadoc)
     * @see com.example.demo.service.IAddressService#deleteAddress(int)
     */
    @Override
    public int deleteAddress(int id) {
        // TODO Auto-generated method stub
        return this.addressDao.deleteByPrimaryKey(id);
    }
    /* (non-Javadoc)
     * @see com.example.demo.service.IAddressService#updateAddress(com.example.demo.pojo.Address)
     */
    @Override
    public int updateAddress(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.updateByPrimaryKey(address);
    }
    /* (non-Javadoc)
     * @see com.example.demo.service.IAddressService#selectallAddress(int)
     */
    @Override
    public List<Address> selectallAddress(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.selectAllAddress(address);
    }
    @Override
    public int updateAddressstatus(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.updateAddressstatus(address);
    }
    @Override
    public int updategetAddress(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.updateAddress(address);
    }
    @Override
    public Address getaddress(String address_openid) {
        // TODO Auto-generated method stub
        return this.addressDao.getaddress(address_openid);
    }
    @Override
    public Address getaddressByid(Integer id) {
        // TODO Auto-generated method stub
        return this.addressDao.getaddressByid(id);
    }
    @Override
    public int updateAddressByid(Address address) {
        // TODO Auto-generated method stub
        return this.addressDao.updateAddressByid(address);
    }

}
