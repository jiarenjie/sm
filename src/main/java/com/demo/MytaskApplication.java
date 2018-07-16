package com.meiling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value={"file:conf/config.properties"})
@ComponentScan(basePackages = {"com.meiling"})
public class MytaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytaskApplication.class, args);
	}
}
