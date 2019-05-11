package cdu.edu.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import cdu.edu.hospital.entity.Common;
import cdu.edu.hospital.entity.Parameter;
import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.service.CommonService;
import cdu.edu.hospital.util.JsonResult;

/**
 * 用于页面上公共参数的查询
 * @author 毅
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	@Autowired
	CommonService commonService;
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult<List<Common>> titleQuery(String name,HttpServletResponse response){
		List<Common> list =  commonService.titleQuery(name);
		return new JsonResult<List<Common>>(list);
	}
	
	@RequestMapping("/parameterQuery.do")
	@ResponseBody
	public JsonResult<List<Parameter>> parameterQuery(HttpServletResponse response){
		List<Parameter> list = commonService.parameterQuery();
	/*	System.out.println(list.get(0).toString());
		System.out.println(list.get(1).toString());*/
		return new JsonResult<List<Parameter>>(list);
	}
	 
	@RequestMapping("/parameterCodeQuery.do")
	@ResponseBody
	public JsonResult<List<Parameter>> parameterCodeQuery(String code,HttpServletResponse response){
		List<Parameter> list = commonService.parameterCodeQuery(code);
		return new JsonResult<List<Parameter>>(list);
	}
	
	@RequestMapping("/parameterCodeSave.do")
	@ResponseBody
	public JsonResult<List<Parameter>>  parameterCodeSave(String code,String list,HttpServletResponse response){
		System.out.println(list);
		String[] parameterCodes = list.split(",");
		for(int i=0;i<parameterCodes.length;i++){
			Integer id = null;
			String[] codes = parameterCodes[i].split(":");
			if(Integer.parseInt(codes[0])==-1){
				codes[0] = null;
				id = null;
			}else{
				id = Integer.parseInt(codes[0]);
			}
			String codees = codes[3];
			String name = codes[2];
			Integer value = Integer.parseInt(codes[1]);
			Parameter parameter = new Parameter();
			parameter.setId(id);
			parameter.setCode(codees);
			parameter.setName(name);
			parameter.setValue(value);
			if(parameter.getId()==null){
				commonService.parameterCodeInsert(parameter);
			}
			if(parameter.getId()!=null){
				commonService.parameterCodeUpdate(parameter);
			}
		}
		return new JsonResult<List<Parameter>>(list);
	}
	
	@RequestMapping("/parameterCodeDelete.do")
	@ResponseBody
	public JsonResult<Parameter>  parameterCodeDelete(Integer id,HttpServletResponse response){
		commonService.parameterCodeDelete(id);
		return new JsonResult<Parameter>(new Parameter());
	}
	 
	
	@RequestMapping("/typeList.do")
	@ResponseBody
	public JsonResult<List<Parameter>> wardTypeQuery(HttpServletRequest request,HttpServletResponse response){
		List<Parameter> list = commonService.wardTypeQuery();
		return new JsonResult<List<Parameter>>(list);
	}
	/**
	 * 民族列表查询
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/nationList.do")
	@ResponseBody
	public JsonResult<List<Parameter>> 	nationQuery(HttpServletRequest request,HttpServletResponse response){
		List<Parameter> list = commonService.nationQuery();
		return new JsonResult<List<Parameter>>(list);
	}
 }
