package com.example.demo.controller;

import java.io.*;
import java.net.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/goc")
public class GetOpenidController {

	
	@RequestMapping("/getopenid")
	public void Getopnid(String code,HttpServletResponse response) throws IOException
	{
		String resopenid = "";
		System.out.println("获取openid");
		String errorcode = "error";
		if(code==null || code=="")
		{
			response.setHeader("Access-Control-Allow-Origin", "*");
			/* 鏄熷彿琛ㄧず鎵�鏈夌殑寮傚煙璇锋眰閮藉彲浠ユ帴鍙楋紝 */
			response.setHeader("Access-Control-Allow-Methods", "GET,POST");
			response.setContentType("text/json,charset=utf-8");
			response.setCharacterEncoding("utf-8");
			
			Writer out = response.getWriter();
			out.write(errorcode);
			out.flush();
			
		}
		
		String url = "https://api.weixin.qq.com/sns/jscode2session?";
		String appid="appid=wx519d30646f94fa66";
		String secret="secret=beda810121c927fb9162408b882a45aa";
		String js_code ="js_code="+code;
		String grant_type = "grant_type=authorization_code";
		
		String urls = url+appid+"&"+secret+"&"+js_code+"&"+grant_type;
		
		resopenid =Connect(urls);
		System.out.println("openid:"+resopenid);
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 鏄熷彿琛ㄧず鎵�鏈夌殑寮傚煙璇锋眰閮藉彲浠ユ帴鍙楋紝 */
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/json,charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		Writer out1 = response.getWriter();
		out1.write(resopenid);
		out1.flush();
		
	}
	
	
	public static String Connect(String address){
		StringBuffer stringBuffer = new StringBuffer();

	        HttpURLConnection conn = null;
	        URL url = null;
	        InputStream in = null;
	        BufferedReader reader = null;
	        try {
	            url = new URL(address);
	            conn = (HttpURLConnection) url.openConnection();
	            conn.setConnectTimeout(5000);
	            conn.setReadTimeout(5000);
	            conn.setDoInput(true);
	            conn.connect();
	            in = conn.getInputStream();
	            reader = new BufferedReader(new      InputStreamReader(in));
	            
	            String line = null;
	            while((line = reader.readLine()) != null){
	                stringBuffer.append(line);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{
	            conn.disconnect();
	            try {
	                in.close();
	                reader.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        System.out.println("++++++++++++++++++++++++");
	        System.out.println(stringBuffer.toString());
			System.out.println("++++++++++++++++++++++++");

		
        return stringBuffer.toString();
    }
	
	
	
	
}
