package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Sugg;
import com.example.demo.service.ISuggService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Sugg")
public class SuggController {

    @Resource
    private ISuggService SuggService;



    @RequestMapping("/addSugg")
    public void addSugg(HttpServletResponse response, Sugg Sugg, String name, String logo, String text, String time,
                        String openid) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        Sugg.setLogo(logo);
        Sugg.setName(name);
        Sugg.setOpenid(openid);
        Sugg.setText(text);
        Sugg.setTime(df.format(new Date()));
        SuggService.insertSelective(Sugg);
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

    @RequestMapping("/selectSuggByOpenid")
    public void selectSuggByOpenid(HttpServletResponse response, Sugg Sugg,
                                   String openid) throws IOException {

        List<Sugg> list=SuggService.selectSuggByOpenid(openid);
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
