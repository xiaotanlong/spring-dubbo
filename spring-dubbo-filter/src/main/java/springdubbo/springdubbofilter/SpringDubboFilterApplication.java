package springdubbo.springdubbofilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springdubbo.springdubbofilter.filter.LimitingFilter;

import javax.servlet.Filter;

@SpringBootApplication
public class SpringDubboFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDubboFilterApplication.class, args);
	}

	/**
	 * 创建一个bean
	 * @return
	 */
	@Bean(name = "sessionFilter")
	public Filter sessionFilter() {
		return new LimitingFilter();
	}
}
