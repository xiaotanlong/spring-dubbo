package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 后台页面服务
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
@ImportResource("classpath:/dubbo/dubbo-consume.xml")
@ComponentScan(value="com.web")//不加扫描  不会加载@Controller 注解
public class SpringbootBootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBootWebApplication.class, args);
	}
}
