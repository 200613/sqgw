package com.example.demo.hcontroller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Customer;
import com.example.demo.service.ICustomerService;

@Controller
@RequestMapping(value = "/hCustomer")
public class HCustomerController {

    @Autowired
    private ICustomerService CustomerService;

    @RequestMapping("/toCustomer")
    private String home(Model model, Customer Customer){
        List<Customer> list=CustomerService.selectCustomer();
        model.addAttribute("customerlist", list);
        return "customer";
    }

    @RequestMapping("/toupdateCustomer")
    private String toupdateCustomer(Model model, Customer Customer,Integer id){
        List<Customer> list=CustomerService.selectCustomer();
        model.addAttribute("customer", CustomerService.selectByPrimaryKey(id));
        return "updatecustomer";
    }

    @RequestMapping("/updateCustomer")
    private String updateCustomer(Model model, Customer Customer,String pwd,String name,String email,String tel,Integer id){
        Customer.setPwd(pwd);
        Customer.setName(name);
        Customer.setEmail(email);
        Customer.setTel(tel);
        Customer.setId(id);
        CustomerService.updateByPrimaryKeySelective(Customer);
        List<Customer> list=CustomerService.selectCustomer();
        model.addAttribute("customerlist", list);
        return "customer";
    }


    @RequestMapping("/deleteCustomer")
    private String deleteCustomer(Model model, Customer Customer,Integer id) throws UnsupportedEncodingException{
        CustomerService.deleteByPrimaryKey(id);
        List<Customer> list=CustomerService.selectCustomer();
        model.addAttribute("customerlist", list);
        return "redirect:toCustomer";
    }

}
