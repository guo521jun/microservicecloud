package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MySelfRule {

	/**
	 * 自定义负载均衡算法
	 */
	@Bean
	public IRule iRule() {
		return new MyRandomRule();
	}
}
