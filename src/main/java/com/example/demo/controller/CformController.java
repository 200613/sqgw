package com.example.demo.controller;

import com.example.demo.pojo.Cform;
import com.example.demo.pojo.Goods;
import com.example.demo.service.ICartService;
import com.example.demo.service.ICformService;
import com.example.demo.service.IGoodsService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/ocform")
public class CformController {

	@Resource
	private ICformService cformService;

	@Resource
	private IGoodsService GoodsService;

	@Resource
	private ICartService cartService;

	@RequestMapping("/addcform")
	public void addcart(HttpServletResponse response,Goods Goods2, String logo, String openid, String name, String oid, String price, Integer count,
			Cform cform, Goods Goods, Integer gid, Integer id, Integer idd) throws IOException {
		System.out.println("��Ӷ�����Ʒ��" + gid + idd);
		Goods Goods1 = new Goods();
		Goods = GoodsService.selectGoodsBygoodid(gid);
		int s = Goods.getFsales() + count;
		Goods2.setId(gid);
		Goods2.setStock(Goods.getStock() - count);
		GoodsService.updateByPrimaryKeySelective(Goods2);
		Goods1.setFsales(s);
		Goods1.setId(gid);
		GoodsService.updateGoods(Goods1);
		cform.setForm_count(count);
		cform.setForm_goodid(gid);
		cform.setForm_logo(logo);
		cform.setForm_name(name);
		cform.setForm_unitprice(price);
		cform.setOrder_id(oid);
		cformService.addcform(cform);
		if (idd == 1) {
			cartService.deleteCart(id);
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

	@RequestMapping("/selectCformbyopenid")
	public void selectCformbyopenid(HttpServletResponse response, String logo, String openid, Cform cform)
			throws IOException {
		List<Cform> list = cformService.selectallCform(cform);
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

	@RequestMapping("/selectByorderid")
	public void selectByorderid(HttpServletResponse response, String logo, String oid, Cform cform) throws IOException {
		System.out.println("oid:" + oid);
		List<Cform> list = cformService.selectgetcform(oid);
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
