package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer   //开启eureka服务器
public class EurekaServer7003App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7003App.class, args);
	}
}
