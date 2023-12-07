package com.example.demo.controller;

import com.example.demo.pojo.Goods;
import com.example.demo.service.IGoodsService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Goods")
public class GoodsController {

	@Resource
	private IGoodsService GoodsService;
	
	@RequestMapping("/selectAllGoods")
	public void selectAllGoods(HttpServletResponse response,Goods Goods) throws IOException {
		List<Goods> list = GoodsService.selectAllGoods(Goods);
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
	
	@RequestMapping("/selectGoodsByFsales")
	public void selectGoodsByFsales(HttpServletResponse response,Goods Goods) throws IOException {
		List<Goods> list = GoodsService.selectGoodsByFsales();
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
	
	@RequestMapping("/selectGoodsById")
	public void selectGoodsById(HttpServletResponse response,Goods Goods,Integer id) throws IOException {
		Goods = GoodsService.selectGoodsById(id);
		System.out.println("��Ʒ;"+Goods.getFname());
		Gson gson = new Gson();
		String json = gson.toJson(Goods);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}
	

	@RequestMapping("/selectBufoodByIfc")
	public void selectBufoodByIfc(HttpServletResponse response,String ifc,Goods Goods) throws IOException {
		System.out.println("ifc:"+ifc);
		List<Goods> list=new ArrayList<>();
		if(ifc.equals("ȫ��")) {
			list = GoodsService.selectAllGoods(Goods);
		}else {
			 list = GoodsService.selectGoodsByifc(ifc);
		}
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
	
	@RequestMapping("/selectBufoodBybid")
	public void selectaddress(HttpServletResponse response,String ifc,Integer bid) throws IOException {
		//ifc=new String(ifc.getBytes("iso-8859-1"), "utf-8");
		List<Goods> list = GoodsService.selectAllGoodsByBid(ifc);
		for(int i=0;i<list.size();i++) {
			System.out.println("sales:"+i+list.get(i).getFsales());
		}
		System.out.println("��Ʒ��"+list.size()+" bid:"+bid+"ifc:"+ifc);
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
	
	
	@RequestMapping("/selectGoodsByName")
	public void selectGoodsByName(HttpServletResponse response,String name,Integer bid) throws IOException {
		//name=new String(name.getBytes("iso-8859-1"), "utf-8");
		System.err.println("name:"+name);
		List<Goods> list = GoodsService.selectGoodsByfname(name);
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
}
