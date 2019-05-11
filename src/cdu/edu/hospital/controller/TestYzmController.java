package cdu.edu.hospital.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.util.CheckCodeGen;
import cdu.edu.hospital.util.ImageYzmUtils;

@Controller
public class TestYzmController{
	
	@RequestMapping("test01")
	protected void doPost(HttpServletRequest reqeust,  HttpServletResponse response) throws ServletException, IOException {  
	     // 设置响应的类型格式为图片格式  
	     response.setContentType("image/jpeg");  
	     // 禁止图像缓存。  
	     response.setHeader("Pragma", "no-cache");  
	     response.setHeader("Cache-Control", "no-cache");  
	     response.setDateHeader("Expires", 0);  
	     ImageYzmUtils instance = new ImageYzmUtils();
	     Cookie cookie = new Cookie("scaptcha", instance.getCode());
	     cookie.setMaxAge(1800);  
	     response.addCookie(cookie);  
	     instance.write(response.getOutputStream());  
	}  
	
	@RequestMapping("image")
	@ResponseBody
	public void validateCodeImg(HttpServletRequest request, HttpServletResponse response) {
		CheckCodeGen code = new CheckCodeGen();
		code.getRandcode(request, response);
	}
	
}
