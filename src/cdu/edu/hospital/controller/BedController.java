package cdu.edu.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.Bed;
import cdu.edu.hospital.service.BedService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.JsonResult;

@Controller
@RequestMapping("/bed")
public class BedController {
	@Autowired
	BedService bedService;
	
	@RequestMapping("/bedQuery.do")
	@ResponseBody
	public JsonResult<List<Bed>> bedQuery(HttpServletRequest request,HttpServletResponse response){
		Bed bed = new Bed();
		bed.setWardNo(BaseUtils.toInteger(request.getParameter("wardNo")));
		bed.setState(0);
		List<Bed> list = bedService.bedQuery(bed);
		return new JsonResult<List<Bed>>(list);
	}
}
