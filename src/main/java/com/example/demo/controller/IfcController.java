package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Ifc;
import com.example.demo.service.IIfcService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/Ifc")
public class IfcController {

    @Resource
    private IIfcService IfcService;

    @RequestMapping("/selectAllIfc")
    public void selectAllIfc(HttpServletResponse response,Ifc Ifc) throws IOException {

        List<Ifc> list = IfcService.selectIfc();
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
