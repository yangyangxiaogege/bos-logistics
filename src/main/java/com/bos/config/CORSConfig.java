package com.bos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.bos.interceptor.LoginInterceptor;

/**
 * web配置
 * @author ASUS
 *
 */
@Configuration
public class CORSConfig extends WebMvcConfigurationSupport{
	/**
     * 跨域请求支持
     */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		        .allowedOrigins("*")
		        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
		        .maxAge(3600)
		        .allowCredentials(true);
	}
	
	/**
	 * 拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// 可以添加多个拦截器
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/sys/*");
	}
   
}
