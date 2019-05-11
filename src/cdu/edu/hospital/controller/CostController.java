package cdu.edu.hospital.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.Cost;
import cdu.edu.hospital.service.CostService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/cost")
public class CostController {
	
	@Autowired
	CostService costService;
	
	@RequestMapping("/costAdd.do")
	@ResponseBody
	public JsonResult<Cost> costAdd(String patientId,String types,String account,String userId){
		Cost cost = new Cost();
		cost.setAccount(BaseUtils.toFloat(account));
		cost.setPatientId(BaseUtils.toString(patientId));
		cost.setType(BaseUtils.toString(types));
		cost.setUserId(BaseUtils.toString(userId));
		String id = System.currentTimeMillis()+"";
		cost.setId(id);
		System.out.println("cost:"+cost);
		//保存
		costService.costAdd(cost);
		return new JsonResult<Cost>(cost);
	}
	
	@RequestMapping("/costQuery.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> costQuery(String id,String patientId,String types,String userId,String startTime,String endTime,String patientName) throws ParseException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("patientId", BaseUtils.toString(patientId));
		map.put("startTime", BaseUtils.toDate(startTime));
		map.put("endTime", BaseUtils.toDate(endTime));
		map.put("patientName", BaseUtils.toString(patientName));		
		List<Map<String, Object>> list = costService.costQuery(map);
 		return new JsonResult<List<Map<String, Object>>>(list);
	}
	
	//费用结算查询
	@RequestMapping("/costTotal.do")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> costTotal(String patientId){
		//费用结算查询
		List<Map<String, Object>> list = costService.costTotal(patientId);
		return new JsonResult<List<Map<String,Object>>>(list);
	}
	
}
