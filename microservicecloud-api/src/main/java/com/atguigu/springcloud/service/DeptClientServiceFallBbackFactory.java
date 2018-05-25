package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component		//千万不要忘记加注解
public class DeptClientServiceFallBbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(Long id) {
				Dept dept = new Dept();
				dept.setId(id);
				dept.setDName("该id:" + id + "没有对应的信息Consumer客户端提供的降级服务，此刻服务provider已经关闭");
				dept.setDbSource("no this database in MYSQL");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
