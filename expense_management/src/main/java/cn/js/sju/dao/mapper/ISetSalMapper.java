package cn.js.sju.dao.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import cn.js.sju.pojo.SalList;
import cn.js.sju.pojo.SetSalary;

public interface ISetSalMapper {
	//发放工资
	int setSal(Map<String, Object> paramMap);
	//获取发放工资人员信息
	SalList getMsg(Map<String, Object> paramMap);
	List<SalList> findallusername();
	int addSetSal(Map<String, Object> alluser);
	//列出所用需发工资的人员
	List<SalList> listSetSal(Map<String, Object> paramMap);
	//查分页
	int findSetSalCount(Map<String, Object> paramMap);
	//发放工资前验证近期是否发过工资
	int verifySal(Map<String, Object> paramMap);
	//查询待修改工资的人员信息
	SalList findUpadateSal(Map<String, Object> paramMap);
	//查询往期账单
	SalList findperUpadateSal(Map<String, Object> paramMap);
	//修改工资
	int updateSal(Map<String, Object> paramMap);
	//修改以往账单
	int preupdateSal(Map<String, Object> paramMap);
	//删除员工工资
	int prereMove(Map<String, Object> paramMap);
	
	


}
