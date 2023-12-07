package com.example.demo.hcontroller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.Store;
import com.example.demo.service.IStoreService;

@Controller
@RequestMapping(value = "/hStore")
public class HStoreController {

	@Autowired
	private IStoreService StoreService;

	@RequestMapping("/toStore")
	private String home(Model model) {
		List<Store> list = StoreService.selectStore();
		model.addAttribute("storelist", list);
		return "store";
	}

	@RequestMapping("/addStore")
	private String addStoredetail(@RequestParam(value = "file") MultipartFile file, Model model, Store Store,
			String pwd, String name, String sname, String stel, String address) throws IOException {
		String path1 = System.getProperty("user.dir");//项目根目录
		String filePath = path1 + "\\src\\main\\resources\\static\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println("originalFilename:" + originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename;
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		Store.setAddress(address);
		Store.setName(name);
		Store.setSname(sname);
		Store.setPwd(pwd);
		Store.setStel(stel);
		Store.setTime(df.format(new Date()));
		Store.setImg("http://127.0.0.1:8080/images/" + newFileName);
		StoreService.insertSelective(Store);
		List<Store> list = StoreService.selectStore();
		model.addAttribute("storelist", list);
		return "store";
	}

	@RequestMapping("/toupdateStore")
	private String viewStore(Model model, Store Store, Integer id) throws IOException {
		System.out.println("id:" + id);
		Store = StoreService.selectByPrimaryKey(id);
		model.addAttribute("store", Store);
		return "updatestore";
	}

	@RequestMapping("/updateStore")
	public String updateproduct(Model model, Store Store, Integer id, String pwd, String name, String sname,
			String stel, String address) throws IllegalStateException, IOException {

		Store.setId(id);
		Store.setAddress(address);
		Store.setName(name);
		Store.setPwd(pwd);
		Store.setSname(sname);
		Store.setPwd(pwd);
		Store.setStel(stel);
		StoreService.updateByPrimaryKeySelective(Store);
		List<Store> list = StoreService.selectStore();
		model.addAttribute("storelist", list);
		return "store";
	}

	@RequestMapping("/deleteStore")
	private String deleteStore(Model model, Store Store, Integer id) throws IOException {
		StoreService.deleteByPrimaryKey(id);
		List<Store> list = StoreService.selectStore();
		model.addAttribute("storelist", list);
		return "store";
	}

}
