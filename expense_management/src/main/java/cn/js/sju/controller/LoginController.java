package cn.js.sju.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.js.sju.pojo.Users;
import cn.js.sju.service.LoginService;
import cn.js.sju.util.MD5;

@Controller
@RequestMapping("/exmg")
public class LoginController {
	
	@Autowired
	private LoginService accountservice;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		if(request!=null) {
			request.getSession().invalidate();
		}
		return "Login";
	}
	
	@PostMapping("/verify")
	@ResponseBody
	public Map<String,Object> verify(@RequestParam("username") String username,
			@RequestParam("password")String password) {
		MD5 md5 = new MD5();
		String md5password=md5.getMD5Encoding(password);
		Users user=accountservice.getuser(username,md5password);
		boolean verify=false;
		Map<String, Object> resultMap = new HashMap<>();
		if(null!=user) {
			verify=true;
			resultMap.put("username", user.getUsername());
			resultMap.put("password", user.getPassword());
			resultMap.put("name", user.getName());
			resultMap.put("phone", user.getPhone());
			resultMap.put("hire", user.getHire());
			resultMap.put("gender", user.getGender());
			resultMap.put("userid", user.getUserid());
		}
		resultMap.put("verify", verify);
		return resultMap;
	}
	
	//ÓÊÏäµÇÂ¼login_email
	@PostMapping("/login_email")
	@ResponseBody
	public Map<String,Object> login_Email(@RequestParam("username") String username,
			@RequestParam("email") String email) {
		Users user=accountservice.login_Email(email,username);
		boolean verify=false;
		Map<String, Object> resultMap = new HashMap<>();
		if(null!=user) {
			verify=true;
			resultMap.put("username", user.getUsername());
			resultMap.put("password", user.getPassword());
			resultMap.put("name", user.getName());
			resultMap.put("phone", user.getPhone());
			resultMap.put("hire", user.getHire());
			resultMap.put("gender", user.getGender());
			resultMap.put("userid", user.getUserid());
		}
		resultMap.put("verify", verify);
		return resultMap;
	}

	//×¢ÏúÕË»§
	@RequestMapping("/quit")
	public String quitUser(HttpServletRequest request) {
		request.getSession().invalidate();
		return "Login";
	}
}
