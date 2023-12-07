package com.example.demo.hcontroller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.User;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IOrderService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/hindex")
public class IndexController {

	
	@Resource
	private IUserService userService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/viewhome")
	public String viewindex1(HttpServletRequest request, Model model, Goods goods) {
		List<Order> olist=orderService.selectallOrder();
		model.addAttribute("ordernum", olist.size());
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodsnum", list.size());
		return "index";
	}
	
}
