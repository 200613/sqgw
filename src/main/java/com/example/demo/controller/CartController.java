package com.example.demo.controller;

import com.example.demo.pojo.Cart;
import com.example.demo.service.ICartService;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource
	private ICartService cartService;
	
	@RequestMapping("/viewcart")
	public void viewcart(HttpServletResponse response,HttpServletRequest request, Model model,String openid) throws IOException {

		List<Cart> list = cartService.getAddressById(openid);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
	
	
	@RequestMapping("/deletecartbyid")
	public void deletecartbyid(HttpServletResponse response,HttpServletRequest request, Model model,String openid,Integer id) throws IOException {
		cartService.deleteCart(id);
		List<Cart> list = cartService.getAddressById(openid);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
	
	@RequestMapping("/addcart")
	public void addcart(HttpServletResponse response,String logo, String openid, String name,Integer id,String price,Integer count,Cart cart1,Cart cart,String goodlogo,Integer sid,String sname) throws IOException {
		System.out.println("openid:"+openid+" id:"+id);
		cart1=cartService.selectgoodCart(id,openid);
		if(cart1==null) {
			System.out.println("添加购物车");
			cart.setCart_goodid(id);
			cart.setCart_goodlogo(goodlogo);
			cart.setCart_goodname(name);
			cart.setCart_goodprice(price);
			cart.setCart_goodcount(count);
			cart.setCart_openid(openid);
			cart.setCart_bid(1);
			cart.setSid(sid);
			cart.setSname(sname);
			cartService.addCart(cart);
		}else {
			System.out.println("澧炲姞鍟嗗搧鏁伴噺");
			
			int i=cart1.getCart_goodcount();
			System.out.print("i"+i);
			int s=1+i;
			System.out.println("s:"+s);
			cart.setCart_goodcount(s);
			cart.setId(cart1.getId());
			cartService.updateCart(cart);
		}
	
		Gson gson = new Gson();
		String json = gson.toJson("0");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}
	
	@RequestMapping("/deletecart")
	public void deletecart(HttpServletResponse response,HttpServletRequest request, Model model,String dlist) throws IOException {
		
		System.out.println("dlist:"+dlist);
		
	      JSONArray jsonArray = JSONArray.fromObject(dlist);
	      int gid=0;
			Object[] os = jsonArray.toArray();
			for (int i = 0; i < os.length; i++) {
				JSONObject jsonObj = JSONObject.fromObject(os[i]);
				if (!jsonObj.isNullObject()) {
					gid = (Integer) jsonObj.get("id");
					System.out.println("goodid:"+gid);
					cartService.deleteCart(gid);
				}
			}
		Gson gson = new Gson();

		String json = gson.toJson("");

		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	@RequestMapping("/deletecartbyCartid")
	public void deletecartbyCartid(Cart cart,Cart cart1,HttpServletResponse response,String openid,
			Integer id) throws IOException {
		System.out.println("id:"+id+" openid:"+openid);
		cart1 = cartService.selectgoodCart(id, openid);
		if(cart1.getCart_goodcount()>1) {
			int i = cart1.getCart_goodcount();
			System.out.print("i" + i);
			int s = i-1;
			System.out.println("s:" + s);
			cart.setCart_goodcount(s);
			cart.setId(cart1.getId());
			cartService.updateCart(cart);
		}else {
			cartService.deleteCart(cart1.getId());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson("");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
