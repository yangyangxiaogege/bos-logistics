package com.bos.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登陆拦截器
 * 没有进行登陆操作前，一系列请求将会被拦截
 * @author ASUS
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	// 请求处理之前，即进入controller之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 判断用户是否登陆
		if (request.getSession().getAttribute("loginUser") == null) {
			// 未进行登陆,不能通过
			System.out.println("未登录");
			return false;
		}
		return true;
	}

}
