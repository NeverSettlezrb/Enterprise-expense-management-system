package cn.js.sju.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.js.sju.dao.mapper.IExpenseMapper;
import cn.js.sju.pojo.Report;

@Repository
public class ExpenseDAO {

	@Autowired
	private IExpenseMapper iExpensemapper;

	public boolean applyReport(Map<String, Object> paramMap) {
		Boolean result;
		int i = iExpensemapper.applyReport(paramMap);

		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	public Map<String, Object> listReport(Map<String, Object> paramMap) {
		//1.获取所有记录数
		Map<String,Object> resultMap = new HashMap<>();
		int count = iExpensemapper.listReportcout(paramMap);
		//2.获取当前页的记录
		List<Report> Report = iExpensemapper.listReportByPage(paramMap);
		for(Report r:Report) {
			if(r.getCaiwu()==0&&r.getJingli()==0) {
				r.setFinallys(0);
			}else if(r.getCaiwu()==0&&r.getJingli()==1) {
				r.setFinallys(0);
			}else if(r.getCaiwu()==1&&r.getJingli()==1) {
				r.setFinallys(1);
			}else if(r.getJingli()==2) {
				r.setFinallys(2);
			}else if(r.getCaiwu()==2&&r.getJingli()==1) {
				r.setFinallys(2);
			}
		}
		resultMap.put("total", count);
		resultMap.put("rows", Report);
		return resultMap;
	}

	public Map<String, Object> listCaireport(Map<String, Object> paramMap) {
		//1.获取所有记录数
				Map<String,Object> resultMap = new HashMap<>();
				int count = iExpensemapper.listCaireport(paramMap);
				//2.获取当前页的记录
				List<Report> Report = iExpensemapper.listCaiReportByPage(paramMap);
				resultMap.put("total", count);
				resultMap.put("rows", Report);
				return resultMap;
	}

	public boolean caiCheckReport(Map<String, Object> paramMap) {
		Boolean result;
		int i = iExpensemapper.caiCheckReport(paramMap);

		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	public Map<String, Object> listJingReport(Map<String, Object> paramMap) {
		//1.获取所有记录数
		Map<String,Object> resultMap = new HashMap<>();
		int count = iExpensemapper.listJingReport(paramMap);
		//2.获取当前页的记录
		List<Report> Report = iExpensemapper.listJingReportByPage(paramMap);
		resultMap.put("total", count);
		resultMap.put("rows", Report);
		return resultMap;
	}

	public boolean jingCheckReport(Integer reid,Integer jingli) {
		Boolean result;
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("reid", reid);
		paramMap.put("jingli", jingli);
		if(jingli==2) {
			paramMap.put("caiwu",3);
			int j = iExpensemapper.caiCheckReport(paramMap);
		}
		int i = iExpensemapper.jingCheckReport(paramMap);

		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	public boolean backCheckReport(Map<String, Object> paramMap) {
		Boolean result;
		int i = iExpensemapper.backCheckReport(paramMap);

		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	public List<Report> costCount() {
		List<Report> result=new ArrayList<Report>();;
		for(int i=1;i<13;i++) {
			result.addAll(iExpensemapper.costCount(i));
		}
		return result;
	}
}
