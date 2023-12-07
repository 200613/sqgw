package com.example.demo.controller;

import com.example.demo.pojo.Colgood;
import com.example.demo.service.ICartService;
import com.example.demo.service.IColgoodService;
import com.google.gson.Gson;
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
@RequestMapping("/Colgood")
public class ColgoodController {

	@Resource
	private IColgoodService ColgoodService;

	@Resource
	private ICartService cartService;

	@RequestMapping("/selectColgoodbyopenid")
	public void selectColgoodbyopenid(HttpServletResponse response, HttpServletRequest request, Model model,
			Colgood Colgood, String openid) throws IOException {
		List<Colgood> list = ColgoodService.selectColgoodByOpenid(openid);
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

	@RequestMapping("/selectColgoodbyopenidGid")
	public void selectColgoodbyopenidGid(HttpServletResponse response, HttpServletRequest request, Model model,
			Colgood Colgood, String openid, Integer gid) throws IOException {
		Colgood = ColgoodService.selectColgoodByOpenidGid(openid, gid);
		Gson gson = new Gson();
		String json = gson.toJson(Colgood);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	@RequestMapping("/addColgood")
	public void addColgood(HttpServletResponse response, HttpServletRequest request, Model model, Colgood Colgood,
			String openid, Integer gid, String img, String name, String price) throws IOException {
		Colgood.setGid(gid);
		Colgood.setImg(img);
		Colgood.setName(name);
		Colgood.setOpenid(openid);
		Colgood.setPrice(price);
		ColgoodService.insertSelective(Colgood);
		Colgood = ColgoodService.selectColgoodByOpenidGid(openid, gid);
		Gson gson = new Gson();
		String json = gson.toJson(Colgood);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	@RequestMapping("/deleteColgood")
	public void addColgood(HttpServletResponse response, HttpServletRequest request, Model model, Colgood Colgood,
			Integer id) throws IOException {
		ColgoodService.deleteByPrimaryKey(id);
		Gson gson = new Gson();
		String json = gson.toJson(Colgood);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
