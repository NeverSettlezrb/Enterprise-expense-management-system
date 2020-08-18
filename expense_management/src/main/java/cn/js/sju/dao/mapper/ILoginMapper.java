package cn.js.sju.dao.mapper;

import org.apache.ibatis.annotations.Param;

import cn.js.sju.pojo.Users;

public interface ILoginMapper {


	Users getuser(@Param("username")String username,@Param("password")String password);

	Users login_Email(@Param("email")String email,@Param("username") String username);

}