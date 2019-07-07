package com.bos.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密工具类
 * @author ASUS
 *
 */
public class PasswordUtil {

	
	/**
	 * Md5加密
	 * @param originalPwd 原始密码
	 * @param condiments 佐料
	 * @return
	 */
	public static String md5(String originalPwd,String condiments){
		return new Md5Hash(originalPwd,condiments).toString();
	}
	
	/**
	 * 测试
	 * @param args
	 */
//	public static void main(String[] args) {
//		String password="admin";
//		System.out.println("Md5加密"+PasswordUtil.md5(password, "admin"));
//	}
}
