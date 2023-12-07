package com.example.demo.hcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Stock;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Ifc;
import com.example.demo.service.IStockService;
import com.google.gson.Gson;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IIfcService;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/hStock")
public class HStockController {

	@Autowired
	private IStockService StockService;

	@Resource
	private IGoodsService GoodsService;


	//进入出入库页面
	@RequestMapping("/toStock")
	private String home(Model model, Stock Stock,Goods Goods) {
		List<Stock> list = StockService.selectStock();
		model.addAttribute("stocklist", list);
		List<Goods> clist = GoodsService.selectAllGoods(Goods);
		model.addAttribute("goodslist", clist);
		return "stock";
	}

	//进入添加出入库页面
	@RequestMapping("/toaddStock")
	private String toaddStock(Model model, Stock Stock,Goods Goods,Integer sid) {
		List<Stock> list = StockService.selectStock();
		model.addAttribute("stocklist", list);
		List<Goods> clist = GoodsService.selectGoodsBySid(sid);
		model.addAttribute("goodslist", clist);
		return "addstock";
	}

	//添加出入库
	@RequestMapping("/addStock")
	private String addStock(HttpServletResponse response,Model model,Goods Goods,Goods gds, Stock Stock, String ifc,Integer sid,Integer gid,
			Integer num,String pname,String sname) throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(new Date()));
		Stock.setIfc(ifc);
		Stock.setNum(num);
		Stock.setTime(df.format(new Date()));
		Stock.setGname(GoodsService.selectGoodsById(gid).getFname());
		Stock.setGid(gid);
		Stock.setPname(pname);
		Stock.setSid(sid);
		Stock.setSname(sname);
		StockService.insertSelective(Stock);
		gds=GoodsService.selectGoodsById(gid);
		if(ifc.equals("出库")) {
			Goods.setStock(gds.getStock()-num);
		}
		if(ifc.equals("入库")) {
			Goods.setStock(gds.getStock()+num);
		}
		Goods.setId(gid);
		GoodsService.updateByPrimaryKeySelective(Goods);
		List<Stock> list = StockService.selectStock();
		model.addAttribute("stocklist", list);
		List<Goods> clist = GoodsService.selectAllGoods(Goods);
		model.addAttribute("goodslist", clist);
		return "stock";
	}

	//进入修改出入库
	@RequestMapping("/toupdateStock")
	private String toupdateStocks(Model model, Stock Stock,Integer id) {
		model.addAttribute("stock", StockService.selectByPrimaryKey(id));
		return "updatestock";
	}

	//修改出入库
	@RequestMapping("/updateStock")
	private String updateStock(HttpServletResponse response,Model model,Goods Goods,Goods gds, Stock Stock,Integer gid, Integer id, String time,String ifc,Integer pid,Integer num) throws IOException {
		gid=StockService.selectByPrimaryKey(id).getGid();
		Stock.setIfc(ifc);
		Stock.setNum(num);
		Stock.setId(id);
		StockService.updateByPrimaryKeySelective(Stock);
		gds=GoodsService.selectGoodsById(gid);
		if(ifc.equals("出库")) {
			Goods.setStock(gds.getStock()-num);
		}
		if(ifc.equals("入库")) {
			Goods.setStock(gds.getStock()+num);
		}
		Goods.setId(gid);
		GoodsService.updateByPrimaryKeySelective(Goods);
		List<Stock> list = StockService.selectStock();
		model.addAttribute("stocklist", list);
		List<Goods> clist = GoodsService.selectAllGoods(Goods);
		model.addAttribute("goodslist", clist);
		return "stock";
	}

	//删除记录
	@RequestMapping("/deleteStock")
	private String deleteStock(Model model, Stock Stock, Integer id,Goods Goods) throws IOException {
		System.out.println("id:" + id);
		StockService.deleteByPrimaryKey(id);
		List<Stock> list = StockService.selectStock();
		model.addAttribute("stocklist", list);
		List<Goods> clist = GoodsService.selectAllGoods(Goods);
		model.addAttribute("goodslist", clist);
		return "stock";
	}

	

}
