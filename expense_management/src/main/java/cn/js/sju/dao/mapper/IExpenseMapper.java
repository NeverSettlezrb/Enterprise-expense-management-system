package cn.js.sju.dao.mapper;

import java.util.List;
import java.util.Map;

import cn.js.sju.pojo.Report;

public interface IExpenseMapper {

	int applyReport(Map<String, Object> paramMap);

	int listReportcout(Map<String, Object> paramMap);
	List<Report> listReportByPage(Map<String, Object> paramMap);

	//�������
	int listCaireport(Map<String, Object> paramMap);
	List<Report> listCaiReportByPage(Map<String, Object> paramMap);

	int caiCheckReport(Map<String, Object> paramMap);
	//�������
	int listJingReport(Map<String, Object> paramMap);
	List<Report> listJingReportByPage(Map<String, Object> paramMap);

	int jingCheckReport(Map<String, Object> paramMap);

	int backCheckReport(Map<String, Object> paramMap);

	List<Report> costCount(int i);

}
