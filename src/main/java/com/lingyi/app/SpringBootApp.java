package com.lingyi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //这是spring的应用入口程序
public class SpringBootApp {
	public static void main(String[] args) {
		
		//该类SpringApplication是springboot的启动类
		SpringApplication.run(SpringBootApp.class, args);
	}
}
