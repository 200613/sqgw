package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Store;
import com.example.demo.service.IStoreService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Store")
public class StoreController {

	@Resource
	private IStoreService StoreService;

	@RequestMapping("/selectStore")
	public void selectStore(HttpServletResponse response,HttpServletRequest request, Model model, Store Store) throws IOException {
		List<Store> list=StoreService.selectStore();
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
	
	@RequestMapping("/selectStoreById")
	public void selectStoreById(HttpServletResponse response,HttpServletRequest request, Model model, Store Store,Integer id) throws IOException {
		Store=StoreService.selectByPrimaryKey(id);
		Gson gson = new Gson();
		String json = gson.toJson(Store);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
