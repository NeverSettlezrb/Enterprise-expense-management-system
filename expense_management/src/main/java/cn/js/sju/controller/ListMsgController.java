package cn.js.sju.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.js.sju.pojo.Dept;
import cn.js.sju.pojo.Position;
import cn.js.sju.pojo.Users;
import cn.js.sju.service.ListMsgService;
import cn.js.sju.util.MD5;

@Controller
@RequestMapping("/exmg")
public class ListMsgController {
	
	@Autowired
	private ListMsgService listuserService;

	//��ҳ��ת
	@RequestMapping("/homepage")
	public String HomePage(@RequestParam("usersname") String usersname,
			@RequestParam("userid")String userid,
			HttpSession session) {
		session.setAttribute("usersname", usersname);
		session.setAttribute("userid", userid);
		return "HomePage";
	}

	
	//�˵�����
	@RequestMapping("/getmenu")
	public void  getMenu(@RequestParam(value="id",required=false)String fatherid,
			@RequestParam(value="username",required=false)String uesrname,
			HttpServletResponse response)throws Throwable {
		String str= listuserService.getMenu(fatherid,uesrname);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(str);
		pw.close();
	}
	
	//�˵�����
		@RequestMapping("/getmenu2")
		public void  getMenu2(@RequestParam(value="id",required=false)String fatherid,
				@RequestParam(value="username",required=false)String uesrname,
				@RequestParam(value="rname",required=false)String rname,
				HttpServletResponse response)throws Throwable {
				int rid = listuserService.getRid(rname);
				String str = listuserService.getMenu2(fatherid,uesrname,rid);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println(str);
			pw.close();
		}
	
	
	//��ҳ��ѯ����
	@RequestMapping("/listsal")
	@ResponseBody
	public Object listemp(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs,
			@RequestParam(value="ename",required=false) String ename,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="sort",required = false) String sort,
			@RequestParam(value="order",required=false) String order
			) {
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("pageRecs"	,pageRecs);
		paramMap.put("currPage", currPage);
		paramMap.put("sort", sort);
		paramMap.put("order", order);
		paramMap.put("name",name);
		paramMap.put("ename",ename);
		
		Map<String,Object> result = listuserService.findEmpsByPage(paramMap);
		return result;
	}
	
	//�г�������Ϣ
	@RequestMapping("/listuserdate")
	@ResponseBody
	public Object listUserDate(@RequestParam(value="username")String username) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username",username);
		
		Map<String,Object> result = listuserService.listUserDate(paramMap);
		return result;
	}
	
	//�޸ĸ�����Ϣ
	@RequestMapping("/updateuserdate")
	@ResponseBody
	public Object updateUserDate(@RequestParam(value="username")String username,
			@RequestParam(value="age")String age,
			@RequestParam(value="phone")String phone,
			@RequestParam(value="gender")String gender,
			@RequestParam(value="email")String email) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username",username);
		paramMap.put("age",age);
		paramMap.put("phone",phone);
		paramMap.put("gender",gender);
		paramMap.put("email",email);
		
		Map<String,Object> result = listuserService.updateUserDate(paramMap);
		return result;
	}
	
	//�˻������޸�
	@RequestMapping("/setusername_pw")
	public String setUserName_Pw(@RequestParam("username") String username) {
		return "../WEB-INF/jsp/setusername_pw";
	}
	//�˻������޸�ע��ҳ��
	@RequestMapping("/setuserpw")
	public String setUserPw() {
		return "../WEB-INF/jsp/setuserpw";
	}
	
	//�����˻�����
	@RequestMapping("/updateuser_pw")
	@ResponseBody
	public Object updateUser_Pw(@RequestParam("username")String username,
			@RequestParam("password")String password,
			@RequestParam("userid")String userid) {
		MD5 md5 = new MD5();
		String md5password=md5.getMD5Encoding(password);
		
		Map<String,Object> resultMap = new HashMap<>();
			
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		paramMap.put("password", md5password);
		paramMap.put("userid", userid);
			
		boolean result = listuserService.updateUser_Pw(paramMap);
			
		resultMap.put("result", result);//result:true
		resultMap.put("msg", result?"�˻���������³ɹ�~":"�Բ���,����ʧ�ܣ������ԣ�");
			
		return resultMap;
	}
	
	//�����û����Ƿ��ظ�
	@RequestMapping("/finduserdate")
	@ResponseBody
	public Map<String,Object> findUserDate(@RequestParam("username") String username){
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("username", username);
		
		int usernameresult = listuserService.findUserDate(paramMap);
		Map<String,Object> resultMap = new HashMap<>();
		
		resultMap.put("usernameresult", usernameresult);
		resultMap.put("username", username);
		return resultMap;
	}
	
	//��ѯ������ְ��Ա
	@RequestMapping("/listusers")
	@ResponseBody
	public Object listUsers(@RequestParam("page") Integer currPage,
			@RequestParam("rows") Integer pageRecs,
			@RequestParam(value="ename",required=false) String ename,
			@RequestParam(value="sort",required = false) String sort,
			@RequestParam(value="order",required=false) String order){
		Map<String,Object> paramMap = new HashMap<>();
		//System.out.println(ename+order);
		paramMap.put("ename",ename);
		paramMap.put("pageRecs"	,pageRecs);
		paramMap.put("currPage", currPage);
		paramMap.put("sort"	,sort);
		paramMap.put("order", order);
		
		Map<String,Object> resultMap = listuserService.listUsers(paramMap);
		System.out.println();
		return resultMap;
	}
	
	@RequestMapping("/insertuser")
	public String insertUser() {
		return "../WEB-INF/jsp/insertuser";
	}
	
	//��ѯ����ְλ
	@RequestMapping("/listrname")
	@ResponseBody
	public List<Position> listRname() {
		return listuserService.listRname();
	}
	
	//�г�����
	@RequestMapping("/listdept")
	@ResponseBody
	public List<Dept> listDept() {
		return listuserService.listDept();
	}

	@RequestMapping("/countdeptno")
	@ResponseBody
	public Map<String,Object> countDeptNo(@RequestParam("deptno") int deptno) {
		Map<String,Object> result = listuserService.countDeptNo(deptno);
		return result;
	}
	
	
	//�����û�
		@RequestMapping("/insertusernew")
		@ResponseBody
		public Object insertUserNew(@RequestParam(value="name",required=false)String name,
				@RequestParam("gender")String gender,
				@RequestParam(value="age",required=false)int age,
				@RequestParam(value="phone",required=false)String phone,
				@RequestParam(value="email",required=false)String email,
				@RequestParam("dept")String dept,
				@RequestParam("rname")String rname,
				@RequestParam("userid")String userid,
				@RequestParam("hire") @DateTimeFormat(pattern = "yyyy-MM-dd") Date hire) {
			MD5 md5 = new MD5();
			String md5password=md5.getMD5Encoding("123456");
			
			Map<String,Object> resultMap = new HashMap<>();
				
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("name", name);
			paramMap.put("email", email);
			paramMap.put("username", userid);
			paramMap.put("gender", gender);
			paramMap.put("password", md5password);
			paramMap.put("phone", phone);
			paramMap.put("age", age);
			paramMap.put("deptno", dept);
			paramMap.put("userid", userid);
			paramMap.put("hire", hire);
			
			Map<String,Object> paramMap2 = new HashMap<>();
			paramMap2.put("rid", rname);
			paramMap2.put("userid", userid);
			boolean result = listuserService.insertUserNew(paramMap,paramMap2);
				
			resultMap.put("result", result);//result:true
			resultMap.put("msg", result?"�����ɹ�~������Ա��������~":"�Բ���,����ʧ�ܣ������ԣ�");
				
			return resultMap;
		}
		
		
		@RequestMapping("/listupdatesusers")
		public String listUpdatesUsers(@RequestParam(value="username")String username,Map<String,Object> result) {
			result.put("username",username);
			return "../WEB-INF/jsp/updatesuser";
		}
		
		//�г����޸���Ա��Ϣ
		@RequestMapping("/updatesusers")
		@ResponseBody
		public Object updatesUsers(@RequestParam(value="username")String username) {
			Map<String,Object> paramMap = new HashMap<>();
			paramMap.put("username",username);
			Map<String,Object> result = listuserService.listUserDate(paramMap);
			return result;
		}
		
		//�޸��û���Ϣ
		@RequestMapping("/updateusersmsg")
		@ResponseBody
		public Object upDateUsersMsg(@RequestParam(value="name",required=false)String name,
				@RequestParam(value="username",required=false)String username,
				@RequestParam(value="gender",required=false)String gender,
				@RequestParam(value="age",required=false)int age,
				@RequestParam(value="phone",required=false)String phone,
				@RequestParam(value="deptno",required=false)String deptno,
				@RequestParam(value="rid",required=false)String rid,
				@RequestParam(value="email",required=false)String email,
				@RequestParam(value="userid",required=false)String userid
				) {
			Map<String,Object> paramMap = new HashMap<>();
							
			paramMap.put("name", name);
			paramMap.put("username", username);
			paramMap.put("gender", gender);
			paramMap.put("phone", phone);
			paramMap.put("age", age);
			paramMap.put("email", email);
			paramMap.put("deptno", deptno);
			paramMap.put("userid", userid);
					
			Map<String,Object> paramMap2 = new HashMap<>();
			paramMap2.put("rid", rid);
			paramMap2.put("userid", userid);
			boolean result = listuserService.upDateUsersMsg(paramMap,paramMap2);
						
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("result", result);//result:true
			resultMap.put("msg", result?"�����ɹ�~������Ա��������~":"�Բ���,����ʧ�ܣ������ԣ�");
						
			return resultMap;
		}
		//��������
		@RequestMapping("/updateusersmsgpassw")
		@ResponseBody
		public Object updateUsersMsgPassW(@RequestParam(value="userid")String userid) {
			Map<String,Object> paramMap = new HashMap<>();	
			MD5 md5 = new MD5();
			String md5password=md5.getMD5Encoding("123456");
			paramMap.put("password", md5password);
			paramMap.put("userid", userid);
			boolean result = listuserService.updateUsersMsgPassW(paramMap);
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("result", result);
			return resultMap;
		}
		
		
		//��ְ��ɾ���û���
		@RequestMapping("/deleteuser")
		@ResponseBody
		public Map<String,Object> deleteUser(@RequestParam("userid") String userid) {
			boolean result = listuserService.deleteUser(userid);
			Map<String,Object> resultMap = new HashMap<>();
			resultMap.put("result", result);//result:true
			resultMap.put("msg", result?"�����ɹ�~���û�����ְ�������ٵ�¼~":"�Բ���,����ʧ�ܣ������ԣ�");
						
			return resultMap;
		}
		
		//��ɫ��ҳ��ʾ
		@RequestMapping("/rolecontrol")
		@ResponseBody
		public Object roleControlByPage(@RequestParam("page") Integer currPage,
				@RequestParam("rows") Integer pageRecs) {
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("currPage", currPage);
			paramMap.put("pageRecs", pageRecs);
			
			Map<String,Object> result = listuserService.roleControlByPage(paramMap);
			return result;
		}
		
		//�����ɫ
		@RequestMapping("/insertrole")
		@ResponseBody
		public Object insertRole(@RequestParam("rname") String rname) {
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("rname", rname);
			Map<String,Object> result = listuserService.insertRole(paramMap);
			return result;
		}
		
		//�˵�Ȩ�޴���
		@RequestMapping("/listrolemeunwin")
		public String listRoleMeun(@RequestParam(value="rname")String rname,Map<String,Object> result) {
			result.put("rname",rname);
			return "../WEB-INF/jsp/listrolemeun";
		}
		
		//�˵�Ȩ�޸���
		@RequestMapping("/insertrole_menu")
		@ResponseBody
		public Object insertRole_Menu(@RequestParam("rname") String rname,
				@RequestParam("rolemenuselect") String rolemenuselect) {
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("rname", rname);
			paramMap.put("mid", rolemenuselect);
			Map<String,Object> result = listuserService.insertRole_Menu(paramMap);
			return result;
		}
		
		
		//�޸Ĳ˵�Ȩ�޴���
		@RequestMapping("/listupdaterolemeunwin")
		public String listUpdateRoleMeun(@RequestParam(value="rname")String rname,Map<String,Object> result) {
			result.put("rname",rname);
			return "../WEB-INF/jsp/listupdaterolemeun";
		}
		//��ȡ��������ɫ�Ĳ˵�
		@RequestMapping("/listroleupdatemenu")
		@ResponseBody
		public Map<String,Object> listRoleUpdateMenu(@RequestParam("rname") String rname) {
			System.out.println(rname);
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("rname", rname);
			List<Position> mname = listuserService.listRoleUpdateMenu(paramMap);
			Map<String,Object> resultMap = new HashMap<>();
			for(Position position : mname) {
				try {
					resultMap.put("mid", position.getMid());
				} catch (Exception e) {
					resultMap.put("mid", "404û������!");
				}
			}
			return resultMap;
		}
		
		
		//�޸Ľ�ɫȨ��
		@RequestMapping("/updaterole_menu")
		@ResponseBody
		public Object updateRole_Menu(@RequestParam("rname") String rname,
				@RequestParam("mid") String mid) {
			Map<String,Object> result = listuserService.updateRole_Menu(rname,mid);
			return result;
		}
		
		
		//ɾ����ɫȨ��
		@RequestMapping("/deleterole")
		@ResponseBody
		public Object deleteRole(@RequestParam("rid") String rid) {
			return listuserService.deleteRole(rid);
		}

		//���ŷ�ҳ��ʾ
		@RequestMapping("/deptcontrol")
		@ResponseBody
		public Object deptControlByPage(@RequestParam("page") Integer currPage,
				@RequestParam("rows") Integer pageRecs) {
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("currPage", currPage);
			paramMap.put("pageRecs", pageRecs);
					
			Map<String,Object> result = listuserService.deptControlByPage(paramMap);
			return result;
		}
		
		//���벿��
		@RequestMapping("/insertdept")
		@ResponseBody
		public Object insertDept(@RequestParam("deptname") String deptname) {
			Map<String,Object> paramMap = new HashMap<>();	
			paramMap.put("deptname", deptname);
			Map<String,Object> result = listuserService.insertDept(paramMap);
			return result;
		}
		
		//ɾ������Ȩ��
		@RequestMapping("/deletedept")
		@ResponseBody
		public Object deleteDept(@RequestParam("deptno") String deptno) {
			return listuserService.deleteDept(deptno);
		}
		
}
