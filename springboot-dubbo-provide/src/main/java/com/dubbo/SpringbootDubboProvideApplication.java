package com.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@ImportResource({ "classpath:dubbo/dubbo-provider.xml" })
public class SpringbootDubboProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProvideApplication.class, args);
	}
}
