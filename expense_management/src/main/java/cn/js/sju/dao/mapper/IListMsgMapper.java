package cn.js.sju.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.js.sju.pojo.Dept;
import cn.js.sju.pojo.Position;
import cn.js.sju.pojo.SalList;
import cn.js.sju.pojo.Users;

public interface IListMsgMapper {
	//菜单管理
	List<Map> getMenu(@Param("fatherid")String fatherid,@Param("username")String username);
	int getRid(String rname);
	List<Map> getMenu2(@Param("fatherid")String fatherid,@Param("username")String username,@Param("rid")int rid);
	//获取当前页薪水
	List<SalList> findEmpsByPage(Map<String, Object> paramMap);
	//薪水分页
	int findEmpsCount(Map<String, Object> paramMap);
	//查询个人信息
	List<Users> listUserDate(Map<String, Object> paramMap);
	//修改个人信息
	int updateUserDate(Map<String, Object> paramMap);
	//修改账户密码
	int updateUser_Pw(Map<String, Object> paramMap);
	//查询用户名
	int findUserDate(Map<String, Object> paramMap);
	//查询所有人信息
	List<Users> listUsers(Map<String, Object> paramMap);
	//查职位
	Users selectrole(String username);
	Users selectrid(String username);
	//分页查询
	int findusersCount(Map<String, Object> paramMaps);
	//查询职位
	List<Position> listRname();
	//查询部门
	List<Dept> listDept();
	int countDeptNo(int deptno);
	//增加新员工
	int insertUserNew(Map<String, Object> paramMap);
	int insertUserNew_rname(Map<String, Object> paramMap);
	//管理员修改员工信息
	int upDateUsersMsg(Map<String, Object> paramMap);
	int updateUsersMsgPassW(Map<String, Object> paramMap);
	void delectUsersMsg_rname(Map<String, Object> paramMap2);
	//删除用户
	int deleteUser(String userid);
	//角色分页查询
	int roleControl(Map<String, Object> paramMap);
	List<SalList> roleControlByPage(Map<String, Object> paramMap);
	//插入角色
	int countinsertRole(Map<String, Object> paramMap);
	int insertRole(Map<String, Object> paramMap);
	int insertRoleexit(Map<String, Object> paramMap);
	//菜单权限赋予
	int insertRole_Menu(Map<String, Object> paramMap);
	//获取待升级角色的菜单
	List<Position> listRoleUpdateMenu(Map<String, Object> paramMap);
	//修改角色权限
	int deleteRoleUpdateMenu(String rname);
	//删除角色权限
	int countDeleteRole(String rid);
	int DeleteRole_Menu(String rid);
	int DeleteRole(String rid);
	//部门分页显示
	int deptControl(Map<String, Object> paramMap);
	List<SalList> deptControlByPage(Map<String, Object> paramMap);
	//插入部门
	int countinsertDept(Map<String, Object> paramMap);
	int insertDept(Map<String, Object> paramMap);
	int insertDeptexit(Map<String, Object> paramMap);
	//删除部门权限
	int countDeleteDept(String deptno);
	int deleteDept(String deptno);

}
