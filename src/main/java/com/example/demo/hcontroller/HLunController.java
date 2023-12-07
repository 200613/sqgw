package com.example.demo.hcontroller;

import com.example.demo.pojo.Lun;
import com.example.demo.service.ILunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/hLun")
public class HLunController {

	@Autowired
	private ILunService LunService;

	@RequestMapping("/toLun")
	private String home(Model model, Lun Lun) {
		List<Lun> list = LunService.selectLun();
		model.addAttribute("lunlist", list);
		return "lun";
	}

	@RequestMapping("/toaddLun")
	private String toaddLun(Model model, Lun Lun) {
		List<Lun> list = LunService.selectLun();
		model.addAttribute("lunlist", list);
		return "addlun";
	}

	@RequestMapping("/addLun")
	private String addLun(@RequestParam(value = "file") MultipartFile file, Model model, Lun Lun, Integer id)
			throws IllegalStateException, IOException {
		String path1 = System.getProperty("user.dir");//项目根目录
		String filePath = path1 + "\\src\\main\\resources\\static\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println("originalFilename:" + originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename;
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);
		Lun.setImg("http://127.0.0.1:8080/images/" + newFileName);
		LunService.insertSelective(Lun);
		List<Lun> list = LunService.selectLun();
		model.addAttribute("lunlist", list);
		return "redirect:toLun";
	}

	@RequestMapping("/toupdateLun")
	private String toupdateLun(Model model, Lun Lun, Integer id) {
		Lun = LunService.selectByPrimaryKey(id);
		model.addAttribute("lun", Lun);
		return "updatelun";
	}

	@RequestMapping("/deleteLun")
	private String deleteLun(Model model, Lun Lun, Integer id) {
		LunService.deleteByPrimaryKey(id);
		List<Lun> list = LunService.selectLun();
		model.addAttribute("lunlist", list);
		return "redirect:toLun";
	}

	@RequestMapping("/updateLun")
	private String updateLun(@RequestParam(value = "file") MultipartFile file, Model model, Lun Lun, Integer id)
			throws IllegalStateException, IOException {
		String path1 = System.getProperty("user.dir");//项目根目录
		String filePath = path1 + "\\src\\main\\resources\\static\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println("originalFilename:" + originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename;
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);
		Lun.setImg("http://127.0.0.1:8080/images/" + newFileName);
		Lun.setId(id);
		LunService.updateByPrimaryKeySelective(Lun);
		List<Lun> list = LunService.selectLun();
		model.addAttribute("lunlist", list);
		return "redirect:toLun";
	}

}
