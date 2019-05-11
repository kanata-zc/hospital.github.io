package cdu.edu.hospital.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdu.edu.hospital.entity.User;
import cdu.edu.hospital.entity.UserCode;
import cdu.edu.hospital.service.NameOrPasswordException;
import cdu.edu.hospital.service.UserService;
import cdu.edu.hospital.util.BaseUtils;
import cdu.edu.hospital.util.CheckCodeGen;
import cdu.edu.hospital.util.JsonResult;

/**
 * 组件扫描
 */
@Controller
@RequestMapping("/account")
public class UserController {
	
	@Autowired
	UserService userService;

	/**
	 * 用户的登录
	 * 
	 * @param statis
	 * @param username
	 * @param password
	 * @param Verification
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult<User> login(String statis, String username, String password, String Verification,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			// 验证码的校验
			boolean checkCodeOk = new CheckCodeGen().verifyCode(Verification, request, false);
			if(checkCodeOk){
				User user = userService.login(username, password);
				Cookie cookie = new Cookie("user", user.getId() + "," + URLEncoder.encode(user.getName(),"utf-8")+","+user.getDescribe());
				// 同一应用服务器内共享方法setPath("/")
				cookie.setPath("/");
				response.addCookie(cookie);
				return new JsonResult<User>(user);
			}else {
				return new JsonResult<User>(3, "验证码错误", null);
			}
		} catch (NameOrPasswordException e) {
			e.printStackTrace();
			return new JsonResult<User>(e.getField(), e.getMessage(), null);
		} catch (Exception e) {
			return new JsonResult<User>(e);
		}
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public JsonResult<User> register(String id, String name, String password, Integer describe, String phone) {
		User user = new User(id, name, password, phone, describe);
		userService.register(user);
		return new JsonResult<User>(user);
	}
	/**
	 * 用户名的校验
	 * @param id
	 * @param response
	 * @return
	 */
	@RequestMapping("/check.do")
	@ResponseBody
	public JsonResult<User> check(String id) {
		User user = userService.findUserById(id);
		if (user == null) {
			return new JsonResult<User>(3, "用户名不存在", null);
		}
		return new JsonResult<User>(user);
	}
	
	/**
	 * 用户的查询
	 * @param describe
	 * @param name
	 * @param id
	 * @param startTime
	 * @param endTime
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/userQuery.do")
	@ResponseBody
	public JsonResult<List<User>> userQuery(String describe, String name, String id,String startTime, String endTime,
			HttpServletResponse response) throws ParseException {
		if("".equals(id)){
			id=null;
		}
		UserCode userCode = new UserCode();
		userCode.setId(id);
		userCode.setName(name);
		Integer des = BaseUtils.toInteger(describe);
		if(des!=null&&des==-1){
			des = null;
		}
		userCode.setDescribe(des);
		if(!(startTime==null||"".equals(startTime))){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date start = (Date) sdf.parse(startTime);  
			userCode.setStartTime(start);
		}
		if(!(endTime==null||"".equals(endTime))){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		    Date end = (Date) sdf.parse(endTime); 
			userCode.setEndTime(end);
		}
		List<User> list = userService.userQuery(userCode);
		return new JsonResult<List<User>>(list);
	}
	
	@RequestMapping("/userDelete.do")
	@ResponseBody
	public JsonResult<User>userDelete(String id,HttpServletResponse response){
		if(id==null||"".equals(id)){
			return new JsonResult<User>(3,"该用户不存在",null);
		}
		userService.userDelete(id);
		return new JsonResult<User>(new User());
	}
	
	@RequestMapping("/getUser.do")
	@ResponseBody
	public JsonResult<User> getUser(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		User user = BaseUtils.getUser(request);
		return new JsonResult<User>(user);
	}
	
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 * @return
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public JsonResult<User> updateUser(String id,String password){
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		userService.updateUser(user);
		return new JsonResult<User>(user);
	}
	//更新用户信息
	@RequestMapping("/updateUserMessage.do")
	@ResponseBody
	public JsonResult<User> updateUserMessage(String id,String name,String phone,Integer state){
		User user = new User();
		user.setId(BaseUtils.toString(id));
		user.setPhone(BaseUtils.toString(phone));
		user.setName(BaseUtils.toString(name));
		user.setDescribe(state);
		userService.updateUserMessage(user);
		return new JsonResult<User>(user);
	}
	//清空Cookie
	@RequestMapping("/clearCookie.do")
	@ResponseBody
	public String clearCookie(HttpServletRequest req,HttpServletResponse res){
		Cookie[] cookies = req.getCookies();
		for(int i = 0,len = cookies.length; i < len; i++) {
			Cookie cookie = new Cookie(cookies[i].getName(),null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			res.addCookie(cookie);
		}
		 return "success";
	}
}
