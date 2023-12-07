package com.example.demo.hcontroller;

import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Ifc;
import com.example.demo.pojo.Order;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IIfcService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/hGoods")
public class HGoodsController {

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private IIfcService IfcService;

	@RequestMapping("/toGoods")
	private String home(Model model, Goods goods) {
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		 List<Ifc> ilist=IfcService.selectIfc();
	        model.addAttribute("ifclist", ilist);
		return "goods";
	}

	@RequestMapping("/toaddGoods")
	private String toaddGoods(Model model, Goods goods) {
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		List<Ifc> ilist=IfcService.selectIfc();
		model.addAttribute("ifclist", ilist);
		return "addgoods";
	}


	@RequestMapping("/getjson")
	private void getjson(HttpServletResponse response, Goods goods) throws IOException {
		List<Goods> list = goodsService.selectAllGoods(goods);
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

	@RequestMapping("/toTongji")
	private String toTongji(Model model, Goods goods) {
		return "goodstongji";
	}

	@RequestMapping("/toGoodsTongji")
	private String toGoodsTongji(Model model, Goods goods) {
		return "tongji";
	}

	@RequestMapping("/toGoodsBingtu")
	private String toGoodsBingtu(Model model, Goods goods) {
		return "bingtu";
	}

	@RequestMapping("/addGoods")
	private String addgoodsdetail(@RequestParam(value = "file") MultipartFile file, Model model, Goods goods,String address,String netcontent,Integer sid,String sname,String remark,
			String bst, String name, String bprice, Double price, String ifc, Integer stock) throws IOException {
		String path1 = System.getProperty("user.dir");//项目根目录
		String filePath = path1 + "\\src\\main\\resources\\static\\images";
		String originalFilename = file.getOriginalFilename();
		System.out.println("originalFilename:" + originalFilename);
		String newFileName = UUID.randomUUID() + originalFilename;
		File targetFile = new File(filePath, newFileName);
		file.transferTo(targetFile);
		goods.setFprice(price);
		goods.setFlogo("http://127.0.0.1:8080/images/" + newFileName);
		goods.setFname(name);
		goods.setIfc(ifc);
		goods.setStock(stock);
		goods.setAddress(address);
		goods.setNetcontent(netcontent);
		goods.setSid(sid);
		goods.setSname(sname);
		goods.setRemark(remark);
		goodsService.insertGoods(goods);
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		 List<Ifc> ilist=IfcService.selectIfc();
	        model.addAttribute("ifclist", ilist);
		return "redirect:toGoods";
	}

	@RequestMapping("/viewgoods")
	private String viewgoods(Model model, Goods goods, Integer id) throws IOException {
		System.out.println("id:" + id);
		goods = goodsService.selectGoodsById(id);
		model.addAttribute("goods", goods);
		List<Ifc> ilist=IfcService.selectIfc();
		model.addAttribute("ifclist", ilist);
		return "updategoods";
	}

	@RequestMapping("/updategoods")
	public String updateproduct(Model model, Goods goods, Integer id, String bst, String name, Integer stock,String address,String netcontent,
			String bprice, Double price, String ifc, String remark) throws IllegalStateException, IOException {
		goods.setId(id);
		goods.setFname(name);
		goods.setIfc(ifc);
		goods.setFprice(price);
		goods.setAddress(address);
		goods.setNetcontent(netcontent);
		goods.setStock(stock);
		goods.setRemark(remark);
		goodsService.updateGoodsById(goods);
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		 List<Ifc> ilist=IfcService.selectIfc();
	        model.addAttribute("ifclist", ilist);
		return "redirect:toGoods";
	}

	@RequestMapping("/updategoodsByStatus")
	public String updategoodsByStatus(Model model, Goods goods, Integer id, String bst, Integer status, Integer stock,
			String bprice, Double nprice, String goodbelong, String logo) throws IllegalStateException, IOException {
		System.out.println("id:"+id+" status:"+status);
		goods.setId(id);
		goods.setStatus(status);
		goodsService.updateGoodsByStatus(goods);
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		List<Ifc> ilist=IfcService.selectIfc();
	    model.addAttribute("ifclist", ilist);
		return "redirect:toGoods";
	}

	@RequestMapping("/deletegoods")
	private String deletegoods(Model model, Goods goods, Integer id) throws IOException {
		System.out.println("id:" + id);
		goodsService.deleteByPrimaryKey(id);
		List<Goods> list = goodsService.selectAllGoods(goods);
		model.addAttribute("goodslist", list);
		 List<Ifc> ilist=IfcService.selectIfc();
	        model.addAttribute("ifclist", ilist);
		return "redirect:toGoods";
	}

	@RequestMapping("/selectgoods")
	private String selectgoods(Model model, Goods goods, String name, String belong) throws IOException {
		System.out.println(name + belong);
		List<Goods> list = goodsService.selectGoodsByfname(name);
		model.addAttribute("goodslist", list);
		 List<Ifc> ilist=IfcService.selectIfc();
	        model.addAttribute("ifclist", ilist);
		return "goods";
	}

}
