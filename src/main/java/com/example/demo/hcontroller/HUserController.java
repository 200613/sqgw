package com.example.demo.hcontroller;

import com.example.demo.pojo.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "/huser")
public class HUserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/touser")
    private String home(Model model, User user){
        List<User> list=userService.selectAllUser(user);
        model.addAttribute("userlist", list);
        return "user";
    }


    @RequestMapping("/toadduser")
    private String toadduser(Model model, User user){
        List<User> list=userService.selectAllUser(user);
        model.addAttribute("userlist", list);
        return "adduser";
    }


    @RequestMapping("/deleteuser")
    private String deleteuser(Model model, User user,Integer id){
        userService.deleteUser(id);
        List<User> list=userService.selectAllUser(user);
        model.addAttribute("userlist", list);
        return "user";
    }

    //viewuserdetaile
    @RequestMapping("/viewuserdetaile")
    private String viewuserdetaile(Model model, User user,Integer id){
        System.out.println("id:"+id);
        user=userService.selectUserById(id);
        model.addAttribute("user", user);
        return "updateuser";
    }


    @RequestMapping("/adduser")
    public String addadmin(Model model,User user,Integer sex,String name,String password,Integer age,String tel,String email,String ctime) throws UnsupportedEncodingException {



        user.setUser_name(name);
        user.setUser_password(password);
        user.setUser_tel(tel);
        user.setUser_email(email);

        user.setUser_age(age);
        user.setUser_gender(sex);

        userService.inserUser(user);

        List<User> list=userService.selectAllUser(user);
        model.addAttribute("userlist", list);
        return "user";
    }

    //
    @RequestMapping("/updateuser")
    public String updateuser(Model model,User user,Integer sex,String name,String password,Integer age,String tel,String email,Integer id) throws UnsupportedEncodingException {



        user.setUser_name(name);
        user.setId(id);
        user.setUser_password(password);
        user.setUser_tel(tel);
        user.setUser_email(email);

        user.setUser_age(age);
        user.setUser_gender(sex);


        userService.updateUser(user);

        List<User> list=userService.selectAllUser(user);
        model.addAttribute("userlist", list);
        return "user";
    }
}
