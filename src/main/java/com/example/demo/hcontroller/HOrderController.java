package com.example.demo.hcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Cform;
import com.example.demo.pojo.Order;
import com.example.demo.service.ICformService;
import com.example.demo.service.IOrderService;

import java.util.List;

@Controller
@RequestMapping(value = "/horder")
public class HOrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ICformService cformService;

    @RequestMapping("/toorder")
    private String home(Model model, Order order){
        List<Order> list=orderService.selectallOrder();
        model.addAttribute("orderlist", list);
        return "order";
    }

    @RequestMapping("/vieworderdetaile")
    private String vieworderdetaile(Model model, Order order, Integer id, Cform cform){
        order=orderService.selectByPrimaryKey(id);
        List<Cform> list=cformService.selectgetcform(order.getOrder_id());
        model.addAttribute("order", order);
        model.addAttribute("cformlist", list);
        return "orderdetail";
    }

    @RequestMapping("/selectorder")
    private String selectorder(Model model, Order order,String orderid){
        List<Order> list=orderService.selectByOrderid(orderid);
        model.addAttribute("orderlist", list);
        return "order";
    }


    @RequestMapping("/toupdatstatus")
    private String toupdatstatus(Model model, Order order,Integer orderstatus,Integer id){

       order= orderService.selectByPrimaryKey(id);
        List<Order> list=orderService.selectallOrder();
        model.addAttribute("order", order);
        return "updateorder";
    }

    @RequestMapping("/updatstatus")
    private String updatstatus(Model model, Order order,Integer orderstatus,Integer id){
        order.setId(id);
        order.setOrder_status(orderstatus);
        orderService.updateIsorderIsstatus(order);
        List<Order> list=orderService.selectallOrder();
        model.addAttribute("orderlist", list);
        return "redirect:toorder";
    }

    @RequestMapping("/deleteorder")
    private String deleteorder(Model model, Order order,Integer orderstatus,Integer id){
        orderService.deleteByPrimaryKey(id);
        List<Order> list=orderService.selectallOrder();
        model.addAttribute("orderlist", list);
        return "order";
    }
}
