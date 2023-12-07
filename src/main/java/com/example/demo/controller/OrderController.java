/**
 *
 */
package com.example.demo.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.pojo.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.pojo.Order;
import com.example.demo.service.ICartService;
import com.example.demo.service.ICformService;
import com.example.demo.service.IOrderService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @Resource
    private ICformService cformService;

    @Resource
    private ICartService cartService;

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/selectOrderbyopenid")
    public void selectOrderbyopenid(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                                    String openid) throws IOException {
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
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

    @RequestMapping("/selectByPrimaryKeyOpenidStatus")
    public void selectByPrimaryKeyOpenidStatus(HttpServletResponse response, HttpServletRequest request, Model model,
                                               Order order, String openid, Integer idx) throws IOException {
        List<Order> list = new ArrayList<>();
        if (idx == 0) {
            list = orderService.selectByPrimaryKeyOpenid(openid);
        } else {
            int status = idx - 1;
            list = orderService.selectByPrimaryKeyOpenidStatus(openid, status);
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

    @RequestMapping("/addOrder")
    public void addOrder(HttpServletResponse response, Customer Customer,Customer cus, Model model, Order order, String ifc,
                         Integer tid, String openid, String linkMan, String mobile, String address, String remark, String money,
                         String goodsJsonStr, String oid, String order_time, Integer sid, String sname, String num, Integer ozid,
                         Integer ocode, Integer id) throws IOException {
        System.out.println("添加订单：" + linkMan);
        order.setOrder_name(linkMan);
        order.setOrder_tel(mobile);
        order.setOrder_address(address);
        order.setOrder_paytime(order_time);
        order.setOrder_status(1);
        order.setOrder_money(money);
        order.setOrder_remark(remark);
        order.setOrder_openid(openid);
        order.setOrder_id(oid);
        order.setIfc(ifc);
        order.setSid(sid);
        order.setSname(sname);
        orderService.insert(order);

        cus=customerService.selectCustomerByOpenid(openid);
        Customer.setNum(num);
        Customer.setId(cus.getId());
        customerService.updateByPrimaryKeySelective(Customer);

        Gson gson = new Gson();
        String json = gson.toJson(order);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    @RequestMapping("/selectOrderbyid")
    public void selectOrderbyid(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                                Integer id) throws IOException {
        order = orderService.selectByPrimaryKey(id);
        Gson gson = new Gson();
        String json = gson.toJson(order);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        response.setContentType("text/json,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
    }

    //
    @RequestMapping("/selectOrderbyBid")
    public void selectOrderbyBid(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                                 Integer bid) throws IOException {
        List<Order> list = orderService.selectBybid(bid);
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

    @RequestMapping("/updateorderstatus")
    public void updateorderstatus(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                                  Integer id, String openid, Integer zid) throws IOException {
        order.setId(id);
        order.setOrder_status(2);
        orderService.updateIsorderIsstatus(order);
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
        System.out.println("list12331:" + list.size());
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

    //
    @RequestMapping("/updateorderstatusByid")
    public void updateorderstatusByid(HttpServletResponse response, HttpServletRequest request, Model model,
                                      Order order, Integer id, String openid) throws IOException {
        order.setId(id);
        order.setOrder_status(3);
        orderService.updateIsorderIsstatus(order);
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
        System.out.println("list12331:" + list.size());
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

    @RequestMapping("/updatetkorderstatusByid")
    public void updatetkorderstatusByid(HttpServletResponse response, HttpServletRequest request, Model model,
                                        Order order, Integer id, String openid) throws IOException {
        order.setId(id);
        order.setOrder_status(4);
        orderService.updateIsorderIsstatus(order);
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
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

    //
    @RequestMapping("/updateOrderById")
    public void updateOrderById(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                                Integer id, String openid) throws IOException {
        order.setId(id);
        order.setOrder_status(1);
        orderService.updateIsorderIsstatus(order);
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
        System.out.println("list12331:" + list.size());
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

    @RequestMapping("/deleteOrder")
    public void deleteOrder(HttpServletResponse response, HttpServletRequest request, Model model, Order order,
                            Integer id, String openid) throws IOException {
        orderService.deleteByPrimaryKey(id);
        List<Order> list = orderService.selectByPrimaryKeyOpenid(openid);
        System.out.println("list12331:" + list.size());
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
