package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka中
public class DeptProvider8001App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001App.class, args);
	}
}
