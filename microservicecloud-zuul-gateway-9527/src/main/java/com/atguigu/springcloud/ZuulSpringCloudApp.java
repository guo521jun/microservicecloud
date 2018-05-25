package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulSpringCloudApp {

	public static void main(String[] args) {
		SpringApplication.run(ZuulSpringCloudApp.class, args);
	}
}
