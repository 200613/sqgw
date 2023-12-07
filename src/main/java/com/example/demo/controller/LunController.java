package com.example.demo.controller;

import com.example.demo.pojo.Lun;
import com.example.demo.service.ICartService;
import com.example.demo.service.ILunService;
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
@RequestMapping("/Lun")
public class LunController {

	@Resource
	private ILunService LunService;

	
	
	@Resource
	private ICartService cartService;

	@RequestMapping("/selectLun")
	public void selectLun(HttpServletResponse response,HttpServletRequest request, Model model, Lun Lun) throws IOException {

	
		List<Lun> list=LunService.selectLun();
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
