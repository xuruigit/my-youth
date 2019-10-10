package com.xurui;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableDubboConfiguration
@SpringBootApplication
public class YouthWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouthWebApplication.class, args);
	}
}
