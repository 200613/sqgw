package com.example.demo.controller;

import com.example.demo.pojo.Customer;
import com.example.demo.service.ICustomerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping(value = "/qcustomer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/getcustomerByOpenid")
	public void getcustomerByOpenid(HttpServletRequest request, Model model, Customer customer, String openid,
			HttpServletResponse response) throws IOException {
		System.out.println("openid:" + openid);
		customer = customerService.selectCustomerByOpenid(openid);
	
		Gson gson = new Gson();
		String json = gson.toJson(customer);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	// ����openid��ȡ�û���Ϣ
	@RequestMapping("/getcustomerOpenid")
	public void getcustomerOpenid(HttpServletRequest request, Model model, Customer customer, String openid,
			HttpServletResponse response) throws IOException {
		System.out.println("openid:" + openid);
		customer = customerService.selectCustomerByOpenid(openid);
		Gson gson = new Gson();
		String json = gson.toJson(customer);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	// ע���û���Ϣ
	@RequestMapping("/addcustomer")
	public void addcustomer(HttpServletRequest request, Model model, Customer customer, String openid, String cname,String email,
			String cpwd, String tel, String cemail, Integer cage, HttpServletResponse response) throws IOException {
		System.out.println("cname:" + cname);
		customer.setPwd(cpwd);
		customer.setOpenid(openid);
		customer.setName(cname);
		customer.setTel(tel);
		customer.setEmail(email);
		customerService.insertSelective(customer);
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
	
	@RequestMapping("/updatecustomer")
	public void updatecustomer(HttpServletRequest request, Model model, Customer customer, String openid, String cname,String email,Integer id,
			String cpwd, String tel, String cemail, Integer cage, HttpServletResponse response) throws IOException {
		System.out.println("cname:" + cname);
		customer.setPwd(cpwd);
		customer.setName(cname);
		customer.setTel(tel);
		customer.setEmail(email);
		customer.setId(id);
		customerService.updateByPrimaryKeySelective(customer);
		Gson gson = new Gson();
		String json = gson.toJson(customerService.selectByPrimaryKey(id));
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	@RequestMapping("/checkcustomer")
	public void checkcustomer(HttpServletRequest request, Model model, Customer customer, String openid, String cname,
			String cpwd, HttpServletResponse response) throws IOException {
	//	cname = new String(cname.getBytes("iso-8859-1"), "utf-8");
		System.out.println("cname:" + cname + openid + cpwd);
		Gson gson = new Gson();
		String json = gson.toJson(customerService.checklogin(cname, cpwd));
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
