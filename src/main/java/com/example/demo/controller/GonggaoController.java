package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.pojo.Gonggao;
import com.example.demo.service.IGonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/Gonggao")
public class GonggaoController {
	
    @Autowired
    private IGonggaoService GonggaoService;
	
    @RequestMapping("/selectGonggao")
    public void selectGonggao(HttpServletRequest request,HttpServletResponse response,String ifc) throws IOException {
    	List<Gonggao> list=GonggaoService.selectGonggao();
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
