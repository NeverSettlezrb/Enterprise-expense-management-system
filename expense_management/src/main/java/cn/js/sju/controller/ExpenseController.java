package cn.js.sju.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.js.sju.pojo.Report;
import cn.js.sju.service.ExpenseService;

@Controller
@RequestMapping("/exmg")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseservice;
	
	@RequestMapping("/applyreport")
	@ResponseBody
	public Object applyReport(@RequestParam(value="money",required=false)Double money,
			@RequestParam("tips")String tips,
			@RequestParam("username")String username,
			@RequestParam("redate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date redate) {
		
			
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("money", money);
		paramMap.put("tips", tips);
		paramMap.put("username", username);
		paramMap.put("redate", redate);
		boolean result = expenseservice.applyReport(paramMap);

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"您已提交报销申请，请耐心等待审核！":"对不起,操作失败，请重试！");
			
		return resultMap;
	}
	
	
	@RequestMapping("/listreport")
	@ResponseBody
	public Object listReport(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs,
			@RequestParam(value="username",required = false)String username) {	
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("currPage", currPage);
		paramMap.put("pageRecs", pageRecs);
		paramMap.put("username", username);
		
		Map<String,Object> resultMap = expenseservice.listReport(paramMap);
		return resultMap;
	}
	
	@RequestMapping("/listcaireport")
	@ResponseBody
	public Object listCaireport(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs,
			@RequestParam(value="username",required = false)String username) {	
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("currPage", currPage);
		paramMap.put("pageRecs", pageRecs);
		paramMap.put("username", username);
		
		Map<String,Object> resultMap = expenseservice.listCaireport(paramMap);
		return resultMap;
	}
	
	//财务审核
	@RequestMapping("/caicheckreport")
	@ResponseBody
	public Object caiCheckReport(@RequestParam("reid") Integer reid
			,@RequestParam("caiwu") Integer caiwu) {	
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("reid", reid);
		paramMap.put("caiwu", caiwu);
		
		boolean result = expenseservice.caiCheckReport(paramMap);

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"操作成功！":"对不起,操作失败，请重试！");
		return resultMap;
	}
	
	//经理审核
	@RequestMapping("/listjingreport")
	@ResponseBody
	public Object listJingReport(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs) {	
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("currPage", currPage);
		paramMap.put("pageRecs", pageRecs);
		
		Map<String,Object> resultMap = expenseservice.listJingReport(paramMap);
		return resultMap;
	}
	
	@RequestMapping("/jingcheckreport")
	@ResponseBody
	public Object jingCheckReport(@RequestParam("reid") Integer reid
			,@RequestParam("jingli") Integer jingli) {	
		
		boolean result = expenseservice.jingCheckReport(reid,jingli);

		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"操作成功！":"对不起,操作失败，请重试！");
		return resultMap;
	}
	
	//撤回重新审核
		@RequestMapping("/backcheckreport")
		@ResponseBody
		public Object backCheckReport(@RequestParam("reid") Integer reid) {	
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("reid", reid);
			
			boolean result = expenseservice.backCheckReport(paramMap);

			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("result", result);//result:true
			resultMap.put("msg", result?"操作成功！":"对不起,操作失败，请重试！");
			return resultMap;
		}
		
		@RequestMapping("/costcount")
		public String costCount(HttpSession session) {
			List<Report> result = new ArrayList(); 
			result=expenseservice.costCount();
//			Map<String,Object> resultMap = new HashMap<>();
//			resultMap.put("result", result);
			return "costcount";
		}
		
}
