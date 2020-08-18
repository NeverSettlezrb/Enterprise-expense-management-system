package cn.js.sju.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.js.sju.dao.mapper.IListMsgMapper;
import cn.js.sju.pojo.Dept;
import cn.js.sju.pojo.Position;
import cn.js.sju.pojo.SalList;
import cn.js.sju.pojo.Users;


@Repository
public class ListMsgDAO {
	
	@Autowired
	private IListMsgMapper ilistmsgMapper;

	//菜单管理
	public List<Map> getMenu(String fatherid,String uesrname) {
		return ilistmsgMapper.getMenu(fatherid,uesrname);
	}
	
	//菜单管理2
		public List<Map> getMenu2(String fatherid,String uesrname,int rid) {
			return ilistmsgMapper.getMenu2(fatherid,uesrname,rid);
		}

	//分页查询薪资
	public Map<String, Object> findEmpsByPage(Map<String, Object> paramMap) {
				//1.获取所有记录数
				Map<String,Object> resultMap = new HashMap<>();
				int count = ilistmsgMapper.findEmpsCount(paramMap);
				//2.获取当前页的记录
				List<SalList> currPageEmpList = ilistmsgMapper.findEmpsByPage(paramMap);
				resultMap.put("total", count);
				resultMap.put("rows", currPageEmpList);
				
				return resultMap;
	}

	//查询用户个人信息
	public Map<String, Object> listUserDate(Map<String, Object> paramMap) {
		Map<String,Object> resultMap = new HashMap<>();
		
		List<Users> currPageEmpList = ilistmsgMapper.listUserDate(paramMap);
		String rnameconat=null;
		if(currPageEmpList!=null) {
			for(Users users : currPageEmpList) {
				Users rid = ilistmsgMapper.selectrid(users.getUsername());
				resultMap.put("rid", rid.getRid());
				resultMap.put("deptno", users.getDeptno());
				resultMap.put("username", users.getUsername());
				resultMap.put("name", users.getName());
				resultMap.put("phone", users.getPhone());
				resultMap.put("hire", users.getHire());
				resultMap.put("gender", users.getGender());
				resultMap.put("age", users.getAge());
				resultMap.put("email", users.getEmail());
				resultMap.put("userid", users.getUserid());
				resultMap.put("age", users.getAge());
				resultMap.put("deptname", users.getDeptname());
				String rname = users.getRname();
				if(rnameconat==null) {
					rnameconat=rname;
				}else {
					rnameconat=rnameconat+"、"+rname;
				}
			}
		}

		resultMap.put("rname", rnameconat);		
		return resultMap;
	}

	//更新个人信息
	public Map<String, Object> updateUserDate(Map<String, Object> paramMap) {
		int	result = ilistmsgMapper.updateUserDate(paramMap);
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("result",result);
		return resultMap;
	}

	//设置账户密码
	public boolean updateUser_Pw(Map<String, Object> paramMap) {
		Boolean result;
		int i = ilistmsgMapper.updateUser_Pw(paramMap);
		if(i==1) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}

	//查询用户名
	public int findUserDate(Map<String, Object> paramMap) {
		int username = ilistmsgMapper.findUserDate(paramMap);
		return username;
	}

	//查询所有人信息
	public Map<String, Object> listUsers(Map<String, Object> paramMaps) {
		Map<String,Object> resultMap = new HashMap<>();
		//1.获取所有记录数
		int count = ilistmsgMapper.findusersCount(paramMaps);
		List<Users> currPageEmpList = ilistmsgMapper.listUsers(paramMaps);
		String username;
		for(Users user : currPageEmpList) {
			username = user.getUsername().toString();
			Users rname = ilistmsgMapper.selectrole(username);
			user.setRname(rname.getRname());
		}
		
		resultMap.put("total", count);
		resultMap.put("rows", currPageEmpList);
		return resultMap;
	}

	public List<Position> listRname() {
		List<Position> currRname = ilistmsgMapper.listRname();
		return currRname;
	}

	public List<Dept> listDept() {
		List<Dept> currDept = ilistmsgMapper.listDept();
		return currDept;
	}

	public Map<String,Object> countDeptNo(int deptno) {
		Map<String,Object> resultMap = new HashMap<>();
		int result = ilistmsgMapper.countDeptNo(deptno);
		resultMap.put("count", result);
		return resultMap;
	}

	//增加新员工
	public boolean insertUserNew(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
		Boolean result;
		int i = ilistmsgMapper.insertUserNew(paramMap);
		String value="";
		int	s=0;
		Object get = paramMap2.get("rid"); 
		if (get instanceof String) {
		   value = (String) get; 
		}
        String[] strArr = value.split(",");
        for (int j = 0; j < strArr.length; ++j){
        	paramMap2.put("rid",strArr[j]);
        	s = ilistmsgMapper.insertUserNew_rname(paramMap2);
        }

		if(s+i==2) {
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	
	
	//管理员修改员工信息
		public boolean upDateUsersMsg(Map<String, Object> paramMap, Map<String, Object> paramMap2) {
			Boolean result;
			int i = ilistmsgMapper.upDateUsersMsg(paramMap);
			ilistmsgMapper.delectUsersMsg_rname(paramMap2);
			String value="";
			int	s=0;
			Object get = paramMap2.get("rid"); 
			if (get instanceof String) {
			   value = (String) get; 
			}
	        String[] strArr = value.split(",");
	        for (int j = 0; j < strArr.length; ++j){
	        	paramMap2.put("rid",strArr[j]);
	        	s = ilistmsgMapper.insertUserNew_rname(paramMap2);
	        }

			if(s+i==2) {
				result=true;
			}else {
				result=false;
			}
			return result;
		}

		//删除用户
		public boolean deleteUser(String userid) {
			Boolean result;
			int i = ilistmsgMapper.deleteUser(userid);
			if(i==1) {
				result=true;
			}else {
				result=false;
			}
			return result;
		}

		//密码重置
		public boolean updateUsersMsgPassW(Map<String, Object> paramMap) {
			Boolean result;
			int i = ilistmsgMapper.updateUsersMsgPassW(paramMap);
			if(i==1) {
				result=true;
			}else {
				result=false;
			}
			return result;
		}

		//角色分页查询
		public Map<String, Object> roleControlByPage(Map<String, Object> paramMap) {
			//1.获取所有记录数
			Map<String,Object> resultMap = new HashMap<>();
			int count = ilistmsgMapper.roleControl(paramMap);
			//2.获取当前页的记录
			List<SalList> currPageroleList = ilistmsgMapper.roleControlByPage(paramMap);
			resultMap.put("total", count);
			resultMap.put("rows", currPageroleList);
			
			return resultMap;
		}

		public Map<String, Object> insertRole(Map<String, Object> paramMap) {
			Boolean result;
			Map<String,Object> resultMap = new HashMap<>();
			int count = ilistmsgMapper.countinsertRole(paramMap);
			
			if(count==0) {
				int i ;
				try {
					i= ilistmsgMapper.insertRole(paramMap);
				} catch (Exception e) {
					i=ilistmsgMapper.insertRoleexit(paramMap);
				}
				if(i==1) {
					result=true;
				}else {
					result=false;
				}
			}else{
				result=false;
			}
			
			resultMap.put("result", result);
			return resultMap;
		}

		//菜单权限赋予
		public Map<String, Object> insertRole_Menu(Map<String, Object> paramMap) {
			Boolean result;
			String value="";
			int	s=0;
			Object get = paramMap.get("mid"); 
			if (get instanceof String) {
			   value = (String) get; 
			}
	        String[] strArr = value.split(",");
	        for (int j=0; j < strArr.length; ++j){
	        	paramMap.put("mid",strArr[j]);
	        	s =s + ilistmsgMapper.insertRole_Menu(paramMap);
	        }

			if(s==strArr.length) {
				result=true;
			}else {
				result=false;
			}
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("result", result);
			return resultMap;
		}

		//获取菜单mid
		public int getRid(String rname) {
			int reslut = ilistmsgMapper.getRid(rname);
			return reslut;
		}
		
		//获取待升级角色的菜单
		public List<Position> listRoleUpdateMenu(Map<String, Object> paramMap) {
			List<Position> currMname = ilistmsgMapper.listRoleUpdateMenu(paramMap);
			return currMname;
		}

		//修改角色权限
		public Map<String, Object> listRoleUpdateMenu(String rname, String mid) {
			Boolean result;
			int delete = ilistmsgMapper.deleteRoleUpdateMenu(rname);
			Map<String,Object> paramMap = new HashMap<>();
				paramMap.put("rname", rname);
				//paramMap.put("mid", mid);
				String value="";
				int	s=0; 
				if (mid instanceof String) {
				   value = (String) mid; 
				}
		        String[] strArr = value.split(",");
		        for (int j=0; j < strArr.length; ++j){
		        	System.out.println(strArr[j]);
		        	if(!strArr[j].equals("404没有数据")) {
		        		paramMap.put("mid",strArr[j]);
		        		s =s + ilistmsgMapper.insertRole_Menu(paramMap);
		        	}else {
		        		s=-1000;
		        	}
		        }
		        
		        if(s==strArr.length) {
					result=true;
				}else if(s==-1000) {
					result=true;
				}else{
					result=false;
				}
				Map<String,Object> resultMap = new HashMap<>();
				resultMap.put("result", result);
			return resultMap;
		}

		//删除角色权限
		public Map<String, Object> deleteRole(String rid) {
			Boolean result;
			String msg="";
			int countuser =ilistmsgMapper.countDeleteRole(rid);
			if(countuser==0) {
				int i = ilistmsgMapper.DeleteRole_Menu(rid);
				int j = ilistmsgMapper.DeleteRole(rid);
				msg="角色已成功删除";
				result=true;
			}else {
				msg="该角色还有员工正在使用！无法删除！";
				result=false;
			}
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("msg", msg);
			resultMap.put("result", result);
			return resultMap;
		}

		//部门分页显示
		public Map<String, Object> deptControlByPage(Map<String, Object> paramMap) {
			//1.获取所有记录数
			Map<String,Object> resultMap = new HashMap<>();
			int count = ilistmsgMapper.deptControl(paramMap);
			//2.获取当前页的记录
			List<SalList> currPageroleList = ilistmsgMapper.deptControlByPage(paramMap);
			resultMap.put("total", count);
			resultMap.put("rows", currPageroleList);
			
			return resultMap;
		}

		//插入部门
		public Map<String, Object> insertDept(Map<String, Object> paramMap) {
			Boolean result;
			Map<String,Object> resultMap = new HashMap<>();
			int count = ilistmsgMapper.countinsertDept(paramMap);
			
			if(count==0) {
				int i ;
				try {
					i= ilistmsgMapper.insertDept(paramMap);
				} catch (Exception e) {
					i=ilistmsgMapper.insertDeptexit(paramMap);
				}
				if(i==1) {
					result=true;
				}else {
					result=false;
				}
			}else{
				result=false;
			}
			
			resultMap.put("result", result);
			return resultMap;
		}

		//删除部门权限
		public Object deleteDept(String deptno) {
			Boolean result;
			String msg="";
			int countuser =ilistmsgMapper.countDeleteDept(deptno);
			if(countuser==0) {
				int j = ilistmsgMapper.deleteDept(deptno);
				msg="部门已成功删除";
				result=true;
			}else {
				msg="还有员工在该部门！无法删除！";
				result=false;
			}
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("msg", msg);
			resultMap.put("result", result);
			return resultMap;
		}

}
