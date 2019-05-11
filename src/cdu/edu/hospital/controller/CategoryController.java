package cdu.edu.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.Category;
import cdu.edu.hospital.service.CategoryService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/categoryQuery.do")
	@ResponseBody
	public JsonResult<List<Category>> categoryQuery(HttpServletRequest request,HttpServletResponse response){
		List<Category> list = categoryService.categoryQuery(new Category());
		return new JsonResult<List<Category>>(list);
	}
	
	@RequestMapping("/categoryUpdate.do")
	@ResponseBody
	public JsonResult<Category> categoryUpdate(HttpServletRequest request,HttpServletResponse response){
		Integer total = BaseUtils.toInteger(request.getParameter("total"));
		for(int i=0;i<total;i++){
			Integer id = BaseUtils.toInteger(request.getParameter("id"+i));
			Float updatePrice = BaseUtils.toFloat(request.getParameter("updatePrice"+i));
			Category category = new Category();
			//如果有修改的值，就更新数据库
			if(updatePrice!=0){
				category.setId(id);
				category.setPrice(updatePrice);
				categoryService.categoryUpdate(category);
			}
		}
		return new JsonResult<Category>(new Category());
	}
	
	
}
