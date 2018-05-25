package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MyConfig {

	@Bean
	@LoadBalanced     //Spring cloud Ribbon是netfilx Ribbon实现的一套客户端  负载均衡工具
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 切换负载均衡算法
	 */
	@Bean
	public IRule iRule() {
		//Ribbon默认的负载均衡算法是轮询
		//改为retry,先使用轮询算法，如果出现问题在改为retry模式
//		return new RetryRule();
		return new RandomRule();	//改为随机
	}
}
