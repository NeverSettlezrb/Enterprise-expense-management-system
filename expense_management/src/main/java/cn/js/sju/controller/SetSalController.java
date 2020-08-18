package cn.js.sju.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.js.sju.pojo.SalList;
import cn.js.sju.service.SetSalService;

@Controller
@RequestMapping("/exmg")
public class SetSalController {
	
	@Autowired
	private SetSalService setsalservice;
	
	//列出人员
	@RequestMapping("/listsetsal")
	@ResponseBody
	public Object listSetSal(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("pageRecs"	,pageRecs);
		paramMap.put("currPage", currPage);
		
		Map<String,Object> result= setsalservice.listSetSal(paramMap);
		//System.out.println(result.get("name"));
		return result;
	}
	
	//发放和验证工资
	@RequestMapping("/setsal")
	@ResponseBody
	public Object setSal(@RequestParam("username") String userame,
						@RequestParam("sal") double sal,
						@RequestParam("sdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata){
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username",userame);
		paramMap.put("sal",sal);
		paramMap.put("sdata",sdata);
		
		Map<String,Object> result = setsalservice.setSal(paramMap);
		return result;
	}
	
	//更新最新工资（到更新页面）
//	@GetMapping("/listsalupdate/{username}")
	@GetMapping("/listsalupdate")
	public String toUpdate(@RequestParam("username") String username,
			@RequestParam("sdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata,
			//@RequestParam("presdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date presdata,
			Map<String,Object> map) {
		//当前工资信息
		SalList sallist = setsalservice.findUpadateSal(username);
		//往期工资信息
		SalList presallist = setsalservice.findperUpadateSal(username,sdata);
		
		map.put("sallist", sallist);
		map.put("presallist",presallist);
		
		return "../WEB-INF/jsp/update";
	}
		
		
	//更新工资
	@PostMapping("/update")
	@ResponseBody
	public Object update(String name,String username,double sal,
			@RequestParam("sdatas") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata) {
		Map<String,Object> resultMap = new HashMap<>();
			
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("name", name);
		paramMap.put("username", username);
		paramMap.put("sal", sal);
		paramMap.put("sdata", sdata);
			
		boolean result = setsalservice.updateSal(paramMap);
			
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"更新成功~":"更新失败！");
			
		return resultMap;
	}
	
	
	//跟新往期工资
	@PostMapping("/preupdate")
	@ResponseBody
	public Object preupdate(@RequestParam("username")String username,
			@RequestParam("sal1")double sal1,
			@RequestParam("sdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata) {
		Map<String,Object> resultMap = new HashMap<>();
			
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("sal", sal1);
		paramMap.put("sdata", sdata);
			
		boolean result = setsalservice.preupdateSal(paramMap);
			
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"更新成功~":"更新失败！");
			
		return resultMap;
	}
	
	//删除工资信息
	@PostMapping("/preremove")
	@ResponseBody
	public Object prereMove(@RequestParam("username")String username,
			@RequestParam("sal1")double sal1,
			@RequestParam("presdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date presdata) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("sal", sal1);
		paramMap.put("sdata", presdata);
		boolean result = setsalservice.prereMove(paramMap);

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"更新成功~":"更新失败！");
		return resultMap;
	}
}
