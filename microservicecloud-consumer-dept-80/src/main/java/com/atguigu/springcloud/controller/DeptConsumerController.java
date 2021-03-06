package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptConsumerController {

//	private static final String REST_URI_PREFIX = "http://localhost:8001";
	private static final String REST_URI_PREFIX = "HTTP://MICROSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URI_PREFIX + "/dept/add", dept, Boolean.class);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URI_PREFIX + "/dept/get/" + id, Dept.class);
	}
	
	@GetMapping("/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URI_PREFIX + "/dept/list", List.class);
	}
	
	//消费端可以调用服务发现
	@GetMapping("/consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URI_PREFIX + "/dept/discovery", Object.class);
	}
}
