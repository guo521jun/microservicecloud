package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController
public class DeptConsumerController {

	@Autowired
	private DeptClientService service;
	
	@GetMapping("/consumer/dept/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	
	@GetMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}
	
	@GetMapping("/consumer/dept/list")
	public List<Dept> list() {
		return service.list();
	}
	
}
