package cn.js.sju.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.js.sju.dao.mapper.ILoginMapper;
import cn.js.sju.pojo.Users;

@Repository
public class LoginDAO {

	@Autowired
	private ILoginMapper iusersmapper;
	
	public Users getuser(String username,String password) {
		return iusersmapper.getuser(username, password);
	}

	public Users login_Email(String email,String username) {
		return iusersmapper.login_Email(email, username);
	}

}
