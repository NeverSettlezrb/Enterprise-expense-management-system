package cn.js.sju.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import cn.js.sju.dao.mapper.ISetSalMapper;
import cn.js.sju.pojo.SalList;

@Repository
public class SetSalDAO {

	@Autowired
	private ISetSalMapper isetsalmapper;
	Date date;
	//���Ź���
	public Map<String, Object> setSal(Map<String, Object> paramMap) {
		Map<String,Object> resultMap = new HashMap<>();
		SalList name= isetsalmapper.getMsg(paramMap);
		int verify = isetsalmapper.verifySal(paramMap);
		int result;
		if(verify==0) {
			result = isetsalmapper.setSal(paramMap);
			resultMap.put("setsal", result);
		}else {
			result = 0;
			resultMap.put("setsal", result);
		}
		String name1 = name.getName().toString();

		resultMap.put("verify",verify);
		resultMap.put("name",name1);
		return resultMap;
	}

	//�г������跢���ʵ���Ա
	public Map<String, Object> listSetSal(Map<String, Object> paramMap) {
		
		List<SalList> alluser = isetsalmapper.findallusername();
		Map<String,Object> allusers = new HashMap<>();
		for (int i =0;i< alluser.size();i++){
			allusers.put("uid",alluser.get(i).getUid());	
			allusers.put("name",alluser.get(i).getName());	
			allusers.put("userid",alluser.get(i).getUserid());
			allusers.put("username",alluser.get(i).getUsername());	
			int s =isetsalmapper.addSetSal(allusers);
		}
		List<SalList> currlist = isetsalmapper.listSetSal(paramMap);
		int count = isetsalmapper.findSetSalCount(paramMap);
		Map<String,Object> resultMap = new HashMap<>();

		resultMap.put("total", count);
		resultMap.put("rows",currlist);
		return resultMap;
	}

	//��ѯ���´��޸Ĺ��ʵ���Ա��Ϣ
	public SalList findUpadateSal(String username) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username",username);
		SalList sallist= isetsalmapper.findUpadateSal(paramMap);
		return sallist;
	}
	
	//��ѯ�����˵�
	public SalList findperUpadateSal(String username,
			@RequestParam("sdata") @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdata) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username",username);
		paramMap.put("sdata",sdata);
		SalList sallist= isetsalmapper.findperUpadateSal(paramMap);
		return sallist;
	}
	
	//�޸Ĺ�����Ϣ
	public boolean updateSal(Map<String, Object> paramMap) {
		Boolean result;
		int i = isetsalmapper.updateSal(paramMap);
		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	//�޸���������
	public boolean preupdateSal(Map<String, Object> paramMap) {
		Boolean result;
		int i = isetsalmapper.preupdateSal(paramMap);
		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	//ɾ������
	public boolean prereMove(Map<String, Object> paramMap) {
		Boolean result;
		int i = isetsalmapper.prereMove(paramMap);
		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	
}
