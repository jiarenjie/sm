package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value={"file:conf/config.properties"})
@ComponentScan(basePackages = {"com.demo"})
public class MytaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytaskApplication.class, args);
	}
}
