package com.main;

import com.common.listener.WebContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * 后台页面服务
 *
 * 发现@SpringBootApplication是一个复合注解，
  			包括
 				@ComponentScan，//扫面包路径 @ComponentScan，扫描当前包及其子包下被@Component，@Controller，@Service，@Repository注解标记的类并纳入到spring容器中进行管理
 				@SpringBootConfiguration，//加载配置
 				@EnableAutoConfiguration。
 * @SpringBootConfiguration继承自@Configuration，
	   二者功能也一致，标注当前类是配置类，
	   并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到srping容器中，
	   并且实例名就是方法名。
 *@EnableAutoConfiguration的作用启动自动的配置，
 			@EnableAutoConfiguration注解的意思就是Springboot根据你添加的jar包来配置你项目的默认配置，
			比如根据spring-boot-starter-web ，来判断你的项目是否需要添加了webmvc和tomcat，
			就会自动的帮你配置web项目中所需要的默认配置。
			在下面博客会具体分析这个注解，快速入门的demo实际没有用到该注解。
 */
@SpringBootApplication //只会扫面当钱包下面的注解  所以这里没有扫描到  TestController  下面在增加一个扫描项
@PropertySource("classpath:application.properties")
@ImportResource("classpath:/dubbo/dubbo-consume.xml")
@ComponentScan(value="com.web,com.common")//这里web是业务模块  名做区分
@Import(value = {WebContextListener.class})
public class SpringbootBootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBootWebApplication.class, args);
	}
}
