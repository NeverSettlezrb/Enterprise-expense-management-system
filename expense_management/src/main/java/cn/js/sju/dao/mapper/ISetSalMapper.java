package cn.js.sju.dao.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import cn.js.sju.pojo.SalList;
import cn.js.sju.pojo.SetSalary;

public interface ISetSalMapper {
	//���Ź���
	int setSal(Map<String, Object> paramMap);
	//��ȡ���Ź�����Ա��Ϣ
	SalList getMsg(Map<String, Object> paramMap);
	List<SalList> findallusername();
	int addSetSal(Map<String, Object> alluser);
	//�г������跢���ʵ���Ա
	List<SalList> listSetSal(Map<String, Object> paramMap);
	//���ҳ
	int findSetSalCount(Map<String, Object> paramMap);
	//���Ź���ǰ��֤�����Ƿ񷢹�����
	int verifySal(Map<String, Object> paramMap);
	//��ѯ���޸Ĺ��ʵ���Ա��Ϣ
	SalList findUpadateSal(Map<String, Object> paramMap);
	//��ѯ�����˵�
	SalList findperUpadateSal(Map<String, Object> paramMap);
	//�޸Ĺ���
	int updateSal(Map<String, Object> paramMap);
	//�޸������˵�
	int preupdateSal(Map<String, Object> paramMap);
	//ɾ��Ա������
	int prereMove(Map<String, Object> paramMap);
	
	


}
