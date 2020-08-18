package cn.js.sju.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.js.sju.pojo.Dept;
import cn.js.sju.pojo.Position;
import cn.js.sju.pojo.SalList;
import cn.js.sju.pojo.Users;

public interface IListMsgMapper {
	//�˵�����
	List<Map> getMenu(@Param("fatherid")String fatherid,@Param("username")String username);
	int getRid(String rname);
	List<Map> getMenu2(@Param("fatherid")String fatherid,@Param("username")String username,@Param("rid")int rid);
	//��ȡ��ǰҳнˮ
	List<SalList> findEmpsByPage(Map<String, Object> paramMap);
	//нˮ��ҳ
	int findEmpsCount(Map<String, Object> paramMap);
	//��ѯ������Ϣ
	List<Users> listUserDate(Map<String, Object> paramMap);
	//�޸ĸ�����Ϣ
	int updateUserDate(Map<String, Object> paramMap);
	//�޸��˻�����
	int updateUser_Pw(Map<String, Object> paramMap);
	//��ѯ�û���
	int findUserDate(Map<String, Object> paramMap);
	//��ѯ��������Ϣ
	List<Users> listUsers(Map<String, Object> paramMap);
	//��ְλ
	Users selectrole(String username);
	Users selectrid(String username);
	//��ҳ��ѯ
	int findusersCount(Map<String, Object> paramMaps);
	//��ѯְλ
	List<Position> listRname();
	//��ѯ����
	List<Dept> listDept();
	int countDeptNo(int deptno);
	//������Ա��
	int insertUserNew(Map<String, Object> paramMap);
	int insertUserNew_rname(Map<String, Object> paramMap);
	//����Ա�޸�Ա����Ϣ
	int upDateUsersMsg(Map<String, Object> paramMap);
	int updateUsersMsgPassW(Map<String, Object> paramMap);
	void delectUsersMsg_rname(Map<String, Object> paramMap2);
	//ɾ���û�
	int deleteUser(String userid);
	//��ɫ��ҳ��ѯ
	int roleControl(Map<String, Object> paramMap);
	List<SalList> roleControlByPage(Map<String, Object> paramMap);
	//�����ɫ
	int countinsertRole(Map<String, Object> paramMap);
	int insertRole(Map<String, Object> paramMap);
	int insertRoleexit(Map<String, Object> paramMap);
	//�˵�Ȩ�޸���
	int insertRole_Menu(Map<String, Object> paramMap);
	//��ȡ��������ɫ�Ĳ˵�
	List<Position> listRoleUpdateMenu(Map<String, Object> paramMap);
	//�޸Ľ�ɫȨ��
	int deleteRoleUpdateMenu(String rname);
	//ɾ����ɫȨ��
	int countDeleteRole(String rid);
	int DeleteRole_Menu(String rid);
	int DeleteRole(String rid);
	//���ŷ�ҳ��ʾ
	int deptControl(Map<String, Object> paramMap);
	List<SalList> deptControlByPage(Map<String, Object> paramMap);
	//���벿��
	int countinsertDept(Map<String, Object> paramMap);
	int insertDept(Map<String, Object> paramMap);
	int insertDeptexit(Map<String, Object> paramMap);
	//ɾ������Ȩ��
	int countDeleteDept(String deptno);
	int deleteDept(String deptno);

}
