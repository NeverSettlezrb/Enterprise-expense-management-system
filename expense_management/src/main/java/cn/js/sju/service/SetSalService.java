package cn.js.sju.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import cn.js.sju.dao.SetSalDAO;
import cn.js.sju.pojo.SalList;

@Service
public class SetSalService {
	
	@Autowired
	private SetSalDAO sersalDAO;

	//发放工资
	@Transactional
	public Map<String, Object> setSal(Map<String, Object> paramMap) {
		
		return sersalDAO.setSal(paramMap);
	}
	//列出所用需发工资的人员
	@Transactional
	public Map<String, Object> listSetSal(Map<String, Object> paramMap) {
		return sersalDAO.listSetSal(paramMap);
	}

	//查询待修改工资的人员信息
	public SalList findUpadateSal(String username) {
		return sersalDAO.findUpadateSal(username);
	}
	
	//更新员工工资
	@Transactional
	public boolean updateSal(Map<String, Object> paramMap) {
		return sersalDAO.updateSal(paramMap);
	}
	public SalList findperUpadateSal(String username
			,@RequestParam("sdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata) {
		return sersalDAO.findperUpadateSal(username,sdata);
	}
	
	
	//更新员工之前工资
	@Transactional
	public boolean preupdateSal(Map<String, Object> paramMap) {
		return sersalDAO.preupdateSal(paramMap);
	}
	
	//删除工资
	public boolean prereMove(Map<String, Object> paramMap) {
		return sersalDAO.prereMove(paramMap);
	}
	
	

}
