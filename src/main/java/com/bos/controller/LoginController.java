package com.bos.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.entity.User;
import com.bos.service.UserService;
import com.bos.utils.Conts;

@RestController
public class LoginController {

	// 注入用户service
	@Resource
	private UserService userService;
	
	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Object login(HttpSession session,User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			map = userService.login(user.getUsername(), user.getPassword());
			
			if (map.get(Conts.LOGIN_USER) != null) {
				// 登陆成功
				session.setAttribute(Conts.LOGIN_USER,map.get(Conts.LOGIN_USER));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put(Conts.MSG, "服务器发生错误,请稍后重试");
		}
		return map;
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public Object register(User user) {
		return true;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/exit")
	public Object exit(HttpSession session) {
		Map<String, Object> map = new HashMap<String,Object>();
		session.removeAttribute(Conts.LOGIN_USER);
		map.put(Conts.STATE, true);
		return map;
	}
}
