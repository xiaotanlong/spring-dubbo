package com.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ImportResource("classpath:/dubbo/dubbo-consume.xml")
public class SpringbootDubboConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboConsumeApplication.class, args);
	}
}
