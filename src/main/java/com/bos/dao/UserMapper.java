package com.bos.dao;

import org.apache.ibatis.annotations.Param;

import com.bos.entity.User;

/**
 * 用户mapper
 * @author ASUS
 *
 */
public interface UserMapper {

	/**
	 * 根据用户名称查询用户信息
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User findUserByName(@Param("username") String username) throws Exception;
}
