package com.example.demo.hcontroller;

import com.example.demo.pojo.Order;
import com.example.demo.service.IOrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;


@Controller
@RequestMapping(value = "/ht")
public class HIndexController {

    @Autowired
    private IOrderService orderService;
 
    @RequestMapping("/toindex")
    private String toindex(Model model){
    
        return "index";
    }

    @RequestMapping("/getjson")
    private void getjson(HttpServletResponse response, Order order) throws IOException {
        List<Order> list=orderService.selectallOrder();
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

    @RequestMapping("/tohome")
    private String home(Model model){
   
        return "home";
    }
}
