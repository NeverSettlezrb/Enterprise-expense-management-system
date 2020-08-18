package cn.js.sju.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.js.sju.dao.ExpenseDAO;
import cn.js.sju.pojo.Report;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseDAO expenseDAO;

	public boolean applyReport(Map<String, Object> paramMap) {
		return expenseDAO.applyReport(paramMap);
	}

	public Map<String, Object> listReport(Map<String, Object> paramMap) {
		return expenseDAO.listReport(paramMap);
	}

	public Map<String, Object> listCaireport(Map<String, Object> paramMap) {
		return expenseDAO.listCaireport(paramMap);
	}

	public boolean caiCheckReport(Map<String, Object> paramMap) {
		return expenseDAO.caiCheckReport(paramMap);
	}

	public Map<String, Object> listJingReport(Map<String, Object> paramMap) {
		return expenseDAO.listJingReport(paramMap);
	}

	public boolean jingCheckReport(Integer reid,Integer jingli) {
		return expenseDAO.jingCheckReport(reid,jingli);
	}

	public boolean backCheckReport(Map<String, Object> paramMap) {
		return expenseDAO.backCheckReport(paramMap);
	}

	public List<Report> costCount() {
		return expenseDAO.costCount();
	}
}
