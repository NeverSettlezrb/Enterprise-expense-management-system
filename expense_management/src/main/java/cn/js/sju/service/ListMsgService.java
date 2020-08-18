package cn.js.sju.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.js.sju.dao.ListMsgDAO;
import cn.js.sju.pojo.Dept;
import cn.js.sju.pojo.Position;

@Service
public class ListMsgService {
	
	@Autowired
	private ListMsgDAO listmsgDAO;

	//�˵�����
	public String getMenu(String fatherid,String uesrname) {
		List<Map> mapList = listmsgDAO.getMenu(fatherid,uesrname);
		if(mapList!=null) {
			for(Map map : mapList) {
				//ֻ��Ҫ����url�Ϳ���
				Object url = map.get("murl");
				if(url!=null) {
					//[{id:1,text:'aaa',children:[],state:"closed",attributes:{url:'xxx.jsp'}]
					//��java�о���Map����Map
					Map<String,Object> attributesMap = new HashMap<>();
					attributesMap.put("url", url);
					map.put("attributes", attributesMap);
				}
			}
		}
		
		ObjectMapper om = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = om.writeValueAsString(mapList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	//mid��ѯ
	public int getRid(String rname) {
		return listmsgDAO.getRid(rname);
	}
	
	public String getMenu2(String fatherid,String uesrname,int rid) {
		List<Map> mapList = listmsgDAO.getMenu2(fatherid,uesrname,rid);
		if(mapList!=null) {
			for(Map map : mapList) {
				//ֻ��Ҫ����url�Ϳ���
				Object url = map.get("murl");
				if(url!=null) {
					//[{id:1,text:'aaa',children:[],state:"closed",attributes:{url:'xxx.jsp'}]
					//��java�о���Map����Map
					Map<String,Object> attributesMap = new HashMap<>();
					attributesMap.put("url", url);
					map.put("attributes", attributesMap);
				}
			}
		}
		
		ObjectMapper om = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = om.writeValueAsString(mapList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	//��ҳ��ѯ����
	public Map<String, Object> findEmpsByPage(Map<String, Object> paramMap) {
		return listmsgDAO.findEmpsByPage(paramMap);
	}

	
	//������Ϣ��ѯ
	public Map<String, Object> listUserDate(Map<String, Object> paramMap) {
		return listmsgDAO.listUserDate(paramMap);
	}
	
	//�޸ĸ�����Ϣ
	public Map<String, Object> updateUserDate(Map<String, Object> paramMap) {
		return listmsgDAO.updateUserDate(paramMap);
	}

	//�����˻�����
	public boolean updateUser_Pw(Map<String, Object> paramMap) {
		return listmsgDAO.updateUser_Pw(paramMap);
	}

	//��ѯ�û���
	public int findUserDate(Map<String, Object> paramMap) {
		return listmsgDAO.findUserDate(paramMap);
	}

	public Map<String, Object> listUsers(Map<String, Object> paramMap) {
		return listmsgDAO.listUsers(paramMap);
	}

	public List<Position> listRname() {
		return listmsgDAO.listRname();
	}

	public List<Dept> listDept() {
		return listmsgDAO.listDept();
	}

	public Map<String,Object> countDeptNo(int deptno) {
		return listmsgDAO.countDeptNo(deptno);
	}

	//����Ա��
	@Transactional
	public boolean insertUserNew(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
		return listmsgDAO.insertUserNew(paramMap,paramMap2);
	}

	//����Ա����Ա����Ϣ
	@Transactional
	public boolean upDateUsersMsg(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
		return listmsgDAO.upDateUsersMsg(paramMap,paramMap2);
	}

	//ɾ���û�
	@Transactional
	public boolean deleteUser(String userid) {
		return listmsgDAO.deleteUser(userid);
	}

	@Transactional
	public boolean updateUsersMsgPassW(Map<String, Object> paramMap) {
		return listmsgDAO.updateUsersMsgPassW(paramMap);
	}

	//��ɫ��ҳ��ѯ
	public Map<String, Object> roleControlByPage(Map<String, Object> paramMap) {
		return listmsgDAO.roleControlByPage(paramMap);
	}

	//��ɫ����
	public Map<String, Object> insertRole(Map<String, Object> paramMap) {
		return listmsgDAO.insertRole(paramMap);
	}

	//�˵�Ȩ�޸���
	@Transactional
	public Map<String, Object> insertRole_Menu(Map<String, Object> paramMap) {
		return listmsgDAO.insertRole_Menu(paramMap);
	}

	//��ȡ��������ɫ�Ĳ˵�
	public List<Position> listRoleUpdateMenu(Map<String, Object> paramMap) {
		return listmsgDAO.listRoleUpdateMenu(paramMap);
	}

	//�޸Ľ�ɫȨ��
	@Transactional
	public Map<String, Object> updateRole_Menu(String rname, String mid) {
		return listmsgDAO.listRoleUpdateMenu(rname,mid);
	}

	
	//ɾ����ɫȨ��
	@Transactional
	public Map<String, Object> deleteRole(String rid) {
		return listmsgDAO.deleteRole(rid);
	}

	//���ŷ�ҳ��ʾ
	public Map<String, Object> deptControlByPage(Map<String, Object> paramMap) {
		return listmsgDAO.deptControlByPage(paramMap);
	}

	//���벿��
	public Map<String, Object> insertDept(Map<String, Object> paramMap) {
		return listmsgDAO.insertDept(paramMap);
	}

	//ɾ������Ȩ��
	public Object deleteDept(String deptno) {
		return listmsgDAO.deleteDept(deptno);
	}

	


}
