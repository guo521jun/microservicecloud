package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进eureka中
@EnableCircuitBreaker  //hystrix对服务熔断的支持
public class DeptProvider8001HystrixApp {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001HystrixApp.class, args);
	}
}
