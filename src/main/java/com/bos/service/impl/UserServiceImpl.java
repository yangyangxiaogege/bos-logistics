package com.bos.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bos.dao.UserMapper;
import com.bos.entity.User;
import com.bos.service.UserService;
import com.bos.utils.Conts;
import com.bos.utils.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	// 注入用户Mapper
	@Resource
	private UserMapper userMapper;

	@Override
	public Map<String, Object> login(String username, String password) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断用户是否存在
		User user = userMapper.findUserByName(username);
		if (user == null) {
			 map.put(Conts.MSG, "用户不存在");
			 return map;
		}

		if (!user.getPassword().equals(PasswordUtil.md5(password, username))) {
			map.put(Conts.MSG, "用户名或密码有误");
			return map;
		}
		
		// 登陆成功
		map.put(Conts.LOGIN_USER, user);
		
		return map;
	}

	@Override
	public User findUserByName(String username) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(username);
	}


}
