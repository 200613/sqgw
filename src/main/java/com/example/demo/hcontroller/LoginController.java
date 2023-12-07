package com.example.demo.hcontroller;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.pojo.Store;
import com.example.demo.pojo.User;
import com.example.demo.service.IStoreService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

@Controller
@RequestMapping("/hlogin")
public class LoginController {

	@Resource
	private IUserService userService;

	@Autowired
	private IStoreService StoreService;

	@RequestMapping("/viewlogin")
	public String viewpaper(HttpServletRequest request, Model model) {
		
		return "login";
	}
	
	//
	@RequestMapping("/checklogin")
	public void checklogin(HttpSession session, HttpServletResponse response, HttpServletRequest request, Store Store, Model model, User user, String name, String pass, Integer role) throws IOException {
		
		System.out.println("name:"+name+" pass:"+pass);
		user=userService.selectCheckLogin(name, pass);
		Store=StoreService.selectStoreByNamePwd(name,pass);
		String s="";
		if(role==0){
			if(Store==null) {
				s="0";
				Gson gson = new Gson();
				String json = gson.toJson(s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				response.setContentType("text/json,charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Writer out = response.getWriter();
				out.write(json);
				out.flush();
			}else {
				s="1";
				session.setAttribute("username", name);
				session.setAttribute("role", role);
				session.setAttribute("sqgw", Store);
				Gson gson = new Gson();
				String json = gson.toJson(s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				response.setContentType("text/json,charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Writer out = response.getWriter();
				out.write(json);
				out.flush();
			}
		}else{
			if(user==null) {
				s="0";
				Gson gson = new Gson();
				String json = gson.toJson(s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				response.setContentType("text/json,charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Writer out = response.getWriter();
				out.write(json);
				out.flush();
			}else {
				s="1";
				session.setAttribute("username", name);
				session.setAttribute("role", role);
				session.setAttribute("sqgw", user);
				Gson gson = new Gson();
				String json = gson.toJson(s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				response.setContentType("text/json,charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Writer out = response.getWriter();
				out.write(json);
				out.flush();
			}
		}

		
	}
}
