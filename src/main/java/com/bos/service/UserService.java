package com.bos.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.User;
/**
 * 用户service接口
 * @author ASUS
 *
 */
public interface UserService {
	
	/**
	 * 登陆验证
	 * @param usename 用户名
	 * @param password 用户密码
	 * @return
	 */
	Map<String, Object> login(String username,String password) throws Exception;
	/**
	 * 根据用户名称查询用户信息
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User findUserByName(@Param("username") String username) throws Exception;
}
