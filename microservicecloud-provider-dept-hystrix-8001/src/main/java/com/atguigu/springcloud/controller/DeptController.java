package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod="processHystrix")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if (null == dept)
			throw new RuntimeException("该id:" + id + "没有对应的信息");
		return dept;
	}
	
	//一旦调用服务失败后并抛出异常，会自动调用@HystrixCommand注解标注的fallbackMethod方法
	public Dept processHystrix(@PathVariable("id") Long id) {
		return new Dept().setId(id)
		.setDName("该id" + id + "没有对应的信息, @HystrixCommand")
		.setDbSource("no this database in MYSQL");
	}
	
	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/discovery", method=RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("******" + list);
		List<ServiceInstance> serviceInstances = client.getInstances("microservicecloud-dept");
		for (ServiceInstance serviceInstance : serviceInstances) {
			System.out.println(serviceInstance.getServiceId() + "\t" + 
							serviceInstance.getHost() + "\t" + 
							serviceInstance.getPort() + "\t" + 
							serviceInstance.getUri());
		}
		return this.client;
	}
}
