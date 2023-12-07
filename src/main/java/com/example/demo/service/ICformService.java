package com.example.demo.service;

import com.example.demo.pojo.Cform;

import java.util.List;


public interface ICformService {
	
	
	//鏌ヨ
			public List<Cform> getcformById(Integer form_goodid);
			
			//娣诲姞
			public int addcform(Cform cform);
			
			public Cform selectByCformid(String order_id);
			
			//鎵�鏈夌敤鎴�
			public List<Cform> selectgetcform(String order_id);
			
			
			public List<Cform> selectallCform(Cform cform);
			
			public int deleteRepeatCform();
			

}
