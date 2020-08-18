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

	//菜单管理
	public String getMenu(String fatherid,String uesrname) {
		List<Map> mapList = listmsgDAO.getMenu(fatherid,uesrname);
		if(mapList!=null) {
			for(Map map : mapList) {
				//只需要处理url就可以
				Object url = map.get("murl");
				if(url!=null) {
					//[{id:1,text:'aaa',children:[],state:"closed",attributes:{url:'xxx.jsp'}]
					//在java中就是Map中套Map
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
	
	//mid查询
	public int getRid(String rname) {
		return listmsgDAO.getRid(rname);
	}
	
	public String getMenu2(String fatherid,String uesrname,int rid) {
		List<Map> mapList = listmsgDAO.getMenu2(fatherid,uesrname,rid);
		if(mapList!=null) {
			for(Map map : mapList) {
				//只需要处理url就可以
				Object url = map.get("murl");
				if(url!=null) {
					//[{id:1,text:'aaa',children:[],state:"closed",attributes:{url:'xxx.jsp'}]
					//在java中就是Map中套Map
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

	//分页查询工资
	public Map<String, Object> findEmpsByPage(Map<String, Object> paramMap) {
		return listmsgDAO.findEmpsByPage(paramMap);
	}

	
	//个人信息查询
	public Map<String, Object> listUserDate(Map<String, Object> paramMap) {
		return listmsgDAO.listUserDate(paramMap);
	}
	
	//修改个人信息
	public Map<String, Object> updateUserDate(Map<String, Object> paramMap) {
		return listmsgDAO.updateUserDate(paramMap);
	}

	//更新账户密码
	public boolean updateUser_Pw(Map<String, Object> paramMap) {
		return listmsgDAO.updateUser_Pw(paramMap);
	}

	//查询用户名
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

	//新增员工
	@Transactional
	public boolean insertUserNew(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
		return listmsgDAO.insertUserNew(paramMap,paramMap2);
	}

	//管理员更新员工信息
	@Transactional
	public boolean upDateUsersMsg(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
		return listmsgDAO.upDateUsersMsg(paramMap,paramMap2);
	}

	//删除用户
	@Transactional
	public boolean deleteUser(String userid) {
		return listmsgDAO.deleteUser(userid);
	}

	@Transactional
	public boolean updateUsersMsgPassW(Map<String, Object> paramMap) {
		return listmsgDAO.updateUsersMsgPassW(paramMap);
	}

	//角色分页查询
	public Map<String, Object> roleControlByPage(Map<String, Object> paramMap) {
		return listmsgDAO.roleControlByPage(paramMap);
	}

	//角色插入
	public Map<String, Object> insertRole(Map<String, Object> paramMap) {
		return listmsgDAO.insertRole(paramMap);
	}

	//菜单权限赋予
	@Transactional
	public Map<String, Object> insertRole_Menu(Map<String, Object> paramMap) {
		return listmsgDAO.insertRole_Menu(paramMap);
	}

	//获取待升级角色的菜单
	public List<Position> listRoleUpdateMenu(Map<String, Object> paramMap) {
		return listmsgDAO.listRoleUpdateMenu(paramMap);
	}

	//修改角色权限
	@Transactional
	public Map<String, Object> updateRole_Menu(String rname, String mid) {
		return listmsgDAO.listRoleUpdateMenu(rname,mid);
	}

	
	//删除角色权限
	@Transactional
	public Map<String, Object> deleteRole(String rid) {
		return listmsgDAO.deleteRole(rid);
	}

	//部门分页显示
	public Map<String, Object> deptControlByPage(Map<String, Object> paramMap) {
		return listmsgDAO.deptControlByPage(paramMap);
	}

	//插入部门
	public Map<String, Object> insertDept(Map<String, Object> paramMap) {
		return listmsgDAO.insertDept(paramMap);
	}

	//删除部门权限
	public Object deleteDept(String deptno) {
		return listmsgDAO.deleteDept(deptno);
	}

	


}
