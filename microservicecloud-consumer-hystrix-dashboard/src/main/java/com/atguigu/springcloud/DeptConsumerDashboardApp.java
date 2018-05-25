package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class DeptConsumerDashboardApp {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerDashboardApp.class, args);
	}
}
