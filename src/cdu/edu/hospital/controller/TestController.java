package cdu.edu.hospital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("test")
	public void test001(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("测试成功！");
		request.setAttribute("test", "测试成功");
		response.sendRedirect("index.jsp");
	}
	
	
}
