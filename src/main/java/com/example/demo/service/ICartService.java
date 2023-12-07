package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Cart;

public interface ICartService {

    public List<Cart> getAddressById(String cart_openid);

    //濞ｈ濮�
    public int addCart(Cart cart);

    //娣囶喗鏁�
    public int updateCart(Cart cart);

    //閸掔娀娅�
    public int deleteCart(int id);

    public int deleteByCartGoodid(Integer cart_goodid,String cart_openid);

    //閹碉拷閺堝鏁ら幋锟�
    public List<Cart> selectallCart(Cart cart);

    public Cart selectgoodCart(Integer cart_goodid,String cart_openid);

    public Cart getCartById(Integer cart_goodid,String cart_openid);

}
