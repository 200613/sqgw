package com.example.demo.hcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.demo.pojo.Gonggao;
import com.example.demo.service.IGonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/hGonggao")
public class HGonggaoController {

	@Autowired
	private IGonggaoService GonggaoService;

	@RequestMapping("/toGonggao")
	private String home(Model model, Gonggao Gonggao) {
		List<Gonggao> list = GonggaoService.selectGonggao();
		model.addAttribute("gonggaolist", list);
		return "gonggao";
	}

	@RequestMapping("/deleteGonggao")
	private String deleteGonggao(Model model, Gonggao Gonggao, Integer id) {
		GonggaoService.deleteByPrimaryKey(id);
		List<Gonggao> list = GonggaoService.selectGonggao();
		model.addAttribute("gonggaolist", list);
		return "redirect:toGonggao";
	}

	@RequestMapping("/toaddGonggao")
	private String toaddGonggao(Model model, Gonggao Gonggao, String biaoti, String content) {

		return "addgonggao";
	}

	@RequestMapping("/addGonggao")
	private String addGonggao(Model model, Gonggao Gonggao, String biaoti, String content) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		Gonggao.setBiaoti(biaoti);
		Gonggao.setContent(content);
		Gonggao.setShijian(df.format(new Date()));
		GonggaoService.insertSelective(Gonggao);
		List<Gonggao> list = GonggaoService.selectGonggao();
		model.addAttribute("gonggaolist", list);
		return "redirect:toGonggao";
	}

	@RequestMapping("/toupdateGonggao")
	private String toupdateGonggao(Model model, Gonggao Gonggao, Integer id) {
		Gonggao = GonggaoService.selectByPrimaryKey(id);
		model.addAttribute("gonggao", Gonggao);
		return "updategonggao";
	}

	@RequestMapping("/updateGonggao")
	private String updateGonggao(Model model, Gonggao Gonggao, String biaoti, String content, Integer id) {
		Gonggao.setBiaoti(biaoti);
		Gonggao.setContent(content);
		Gonggao.setId(id);
		GonggaoService.updateByPrimaryKeySelective(Gonggao);
		List<Gonggao> list = GonggaoService.selectGonggao();
		model.addAttribute("gonggaolist", list);
		return "redirect:toGonggao";
	}

}
