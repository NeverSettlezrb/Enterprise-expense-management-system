package cn.js.sju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.js.sju.dao.LoginDAO;
import cn.js.sju.pojo.Users;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO accountDAO;
	
	@Transactional
	public Users getuser(String username,String password) {
		return accountDAO.getuser(username, password);
	}

	//” œ‰µ«¬º
	public Users login_Email(String email,String username) {
		return accountDAO.login_Email(email,username);
	}
	
}
