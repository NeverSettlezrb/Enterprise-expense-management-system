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

	//���Ź���
	@Transactional
	public Map<String, Object> setSal(Map<String, Object> paramMap) {
		
		return sersalDAO.setSal(paramMap);
	}
	//�г������跢���ʵ���Ա
	@Transactional
	public Map<String, Object> listSetSal(Map<String, Object> paramMap) {
		return sersalDAO.listSetSal(paramMap);
	}

	//��ѯ���޸Ĺ��ʵ���Ա��Ϣ
	public SalList findUpadateSal(String username) {
		return sersalDAO.findUpadateSal(username);
	}
	
	//����Ա������
	@Transactional
	public boolean updateSal(Map<String, Object> paramMap) {
		return sersalDAO.updateSal(paramMap);
	}
	public SalList findperUpadateSal(String username
			,@RequestParam("sdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata) {
		return sersalDAO.findperUpadateSal(username,sdata);
	}
	
	
	//����Ա��֮ǰ����
	@Transactional
	public boolean preupdateSal(Map<String, Object> paramMap) {
		return sersalDAO.preupdateSal(paramMap);
	}
	
	//ɾ������
	public boolean prereMove(Map<String, Object> paramMap) {
		return sersalDAO.prereMove(paramMap);
	}
	
	

}
