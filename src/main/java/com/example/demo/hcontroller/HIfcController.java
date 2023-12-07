package com.example.demo.hcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Ifc;
import com.example.demo.service.IIfcService;

@Controller
@RequestMapping(value = "/hIfc")
public class HIfcController {


    @Autowired
    private IIfcService IfcService;

    @RequestMapping("/toIfc")
    private String home(Model model,Ifc Ifc){
        List<Ifc> list=IfcService.selectIfc();
        model.addAttribute("ifclist", list);
        return "ifc";
    }

    @RequestMapping("/toaddIfc")
    private String toaddIfc(Model model,Ifc Ifc){
        List<Ifc> list=IfcService.selectIfc();
        model.addAttribute("ifclist", list);
        return "addifc";
    }

    @RequestMapping("/toupdateIfc")
    private String toupdaetIfc(Model model,Ifc Ifc,Integer id){
        Ifc=IfcService.selectByPrimaryKey(id);
        model.addAttribute("ifc", Ifc);
        return "updateifc";
    }




    @RequestMapping("/addIfc")
    private String addIfcdetail( Model model, Ifc Ifc,String txt) throws IOException {
        Ifc.setTxt(txt);
        IfcService.insertSelective(Ifc);
        List<Ifc> list=IfcService.selectIfc();
        model.addAttribute("ifclist", list);
        return "redirect:toIfc";
    }

    @RequestMapping("/updateIfc")
    private String updateIfc( Model model, Ifc Ifc,Integer id,String txt) throws IOException {
        Ifc.setTxt(txt);
        Ifc.setId(id);
        IfcService.updateByPrimaryKeySelective(Ifc);
        List<Ifc> list=IfcService.selectIfc();
        model.addAttribute("ifclist", list);
        return "redirect:toIfc";
    }

    @RequestMapping("/deleteIfc")
    private String deleteIfc( Model model, Ifc Ifc,Integer id,String txt) throws IOException {

        IfcService.deleteByPrimaryKey(id);
        List<Ifc> list=IfcService.selectIfc();
        model.addAttribute("ifclist", list);
        return "redirect:toIfc";
    }

}
