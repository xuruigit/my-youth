package com.xurui;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author XuRui
 * @date 2018/4/19
 */

@EnableDiscoveryClient
@EnableDubboConfiguration
@SpringBootApplication
public class YouthApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouthApplication.class, args);
	}
}
