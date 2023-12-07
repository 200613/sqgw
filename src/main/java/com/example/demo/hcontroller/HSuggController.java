package com.example.demo.hcontroller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Sugg;
import com.example.demo.service.ISuggService;

@Controller
@RequestMapping(value = "/hSugg")
public class HSuggController {

    @Autowired
    private ISuggService SuggService;

    @RequestMapping("/toSugg")
    private String toSugg(Model model, Sugg Sugg){
        List<Sugg> list=SuggService.selectSugg();
        model.addAttribute("sugglist", list);
        return "sugg";
    }

    @RequestMapping("/toupdateSugg")
    private String toupdateSugg(Model model, Sugg Sugg,Integer id){
        Sugg=SuggService.selectByPrimaryKey(id);
        model.addAttribute("sugg", Sugg);
        return "updatesugg";
    }

    @RequestMapping("/deleteSugg")
    private String deleteSugg(Model model, Sugg Sugg,Integer id){
        SuggService.deleteByPrimaryKey(id);
        List<Sugg> list=SuggService.selectSugg();
        model.addAttribute("sugglist", list);
        return "redirect:toSugg";
    }

    @RequestMapping("/updateSugg")
    private String updateSugg(Model model, Sugg Sugg,Integer id,String reply) throws UnsupportedEncodingException{
        Sugg.setId(id);
        Sugg.setStatus(1);
        Sugg.setReply(reply);
        SuggService.updateByPrimaryKeySelective(Sugg);
        List<Sugg> list=SuggService.selectSugg();
        model.addAttribute("sugglist", list);
        return "sugg";
    }

}
