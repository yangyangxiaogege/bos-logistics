	package com.bos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // springboot应用
@MapperScan(basePackages="com.bos.dao") // 扫描dao,生成mapper代理
public class BosLogisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BosLogisticsApplication.class, args);
	}
}
