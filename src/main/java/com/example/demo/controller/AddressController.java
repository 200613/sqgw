package com.example.demo.controller;

import com.example.demo.pojo.Address;
import com.example.demo.service.IAddressService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Resource
	private IAddressService addressService;

	@RequestMapping("/addaddress")
	public void addaddress(HttpServletResponse response,Model model, Address address, String name, String mobile,
			String addressdetailed, String openid, String province, String city, String district)
			throws IOException {
		List<Address> list = addressService.getAddressById(openid);

		if (list.size() == 0) {
			address.setAddress_default(1);
		} else { 
			address.setAddress_default(0);
		} 

		address.setAddress_cusname(name);
		address.setAddress_cusphone(mobile);
		address.setAddress_openid(openid);
		address.setAddress_cusaddress(addressdetailed);
		address.setAddress_cusprovince(province);
		address.setAddress_cuscity(city);
		address.setAddress_cusdistrict(district);
		addressService.addAddress(address);
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

	@RequestMapping("/updateAddressByid")
	public void updateAddressByid(HttpServletResponse response,Model model, Address address, Integer id, String name,
			String mobile, String addressdetailed, String openid, String province, String city, String district)
			throws IOException {
		System.out.println("addressdetailed锛�" + addressdetailed);
		address.setId(id);
		address.setAddress_cusname(name);
		address.setAddress_cusphone(mobile);
		address.setAddress_cusaddress(addressdetailed);
		address.setAddress_cusprovince(province);
		address.setAddress_cuscity(city);
		address.setAddress_cusdistrict(district);
		addressService.updateAddressByid(address);
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

	@RequestMapping("/selectaddress")
	public void selectaddress(HttpServletResponse response, String openid) throws IOException {

		List<Address> list = addressService.getAddressById(openid);
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

	@RequestMapping("/selectaddressByid")
	public void selectaddressByid(HttpServletResponse response, Integer id) throws IOException {
		System.out.println("id:" + id);
		Address address = addressService.getaddressByid(id);
		Gson gson = new Gson();
		String json = gson.toJson(address);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	@RequestMapping("/deleteAddress")
	public void deleteAddress(HttpServletResponse response, Integer id) throws IOException {
		addressService.deleteAddress(id);

	}

	@RequestMapping("/updateaddress")
	public void updateaddress(HttpServletResponse response, String openid, Integer id, Address address)
			throws IOException {
		System.out.println("id:" + id);
		address.setAddress_openid(openid);
		address.setAddress_default(0);
		addressService.updategetAddress(address);
		Address address1 = new Address();
		address1.setId(id);
		address1.setAddress_default(1);
		addressService.updateAddressstatus(address1);
		List<Address> list = addressService.getAddressById(openid);
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

	@RequestMapping("/getaddress")
	public void getaddress(HttpServletResponse response, String openid, Integer id, Address address)
			throws IOException {
		System.out.println("id:" + id);
		address = addressService.getaddress(openid);
		Gson gson = new Gson();
		String json = gson.toJson(address);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
