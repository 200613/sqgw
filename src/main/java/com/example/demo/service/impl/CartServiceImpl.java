package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ICartDao;
import com.example.demo.pojo.Cart;
import com.example.demo.service.ICartService;

@Service("cartService")
public class CartServiceImpl implements ICartService{

    @Resource
    private ICartDao cartDao;

    @Override
    public List<Cart> getAddressById(String cart_openid) {
        // TODO Auto-generated method stub
        return this.cartDao.selectByPrimaryKey(cart_openid);
    }

    @Override
    public int addCart(Cart cart) {
        // TODO Auto-generated method stub
        return this.cartDao.insert(cart);
    }


    @Override
    public int deleteCart(int id) {
        // TODO Auto-generated method stub
        return this.cartDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Cart> selectallCart(Cart cart) {
        // TODO Auto-generated method stub
        return this.cartDao.selectAllCart(cart);
    }

    @Override
    public Cart selectgoodCart(Integer cart_goodid, String cart_openid) {
        // TODO Auto-generated method stub
        return this.cartDao.selectgoodCart(cart_goodid, cart_openid);
    }

    @Override
    public int updateCart(Cart cart) {
        // TODO Auto-generated method stub
        return this.cartDao.updategoodcart(cart);
    }

    @Override
    public Cart getCartById(Integer cart_goodid, String cart_openid) {
        // TODO Auto-generated method stub
        return this.cartDao.findBycart(cart_goodid, cart_openid);
    }

    @Override
    public int deleteByCartGoodid(Integer cart_goodid, String cart_openid) {
        // TODO Auto-generated method stub
        return this.cartDao.deleteByCartGoodid(cart_goodid, cart_openid);
    }

}
