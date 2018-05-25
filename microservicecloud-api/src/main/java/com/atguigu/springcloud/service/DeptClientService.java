package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.atguigu.springcloud.entities.Dept;

//@FeignClient(name="MICROSERVICECLOUD-DEPT")
@FeignClient(value="MICROSERVICECLOUD-DEPT", fallbackFactory=DeptClientServiceFallBbackFactory.class)
public interface DeptClientService {

	@PostMapping("/dept/add")
	boolean add(Dept dept);
	
	@GetMapping("/dept/get/{id}")
	Dept get(@PathVariable("id") Long id);
	
	@GetMapping("/dept/list")
	List<Dept> list();
}