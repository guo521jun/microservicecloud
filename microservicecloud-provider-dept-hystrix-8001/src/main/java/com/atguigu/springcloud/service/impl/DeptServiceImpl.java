package com.atguigu.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDAO;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDAO deptDAO;
	
	@Override
	public boolean add(Dept dept) {
		return deptDAO.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDAO.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDAO.findAll();
	}

}
