package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import config.WebConfig;
import domain.BaseEntity;


@Import(WebConfig.class)
@EnableAutoConfiguration
@EntityScan(basePackageClasses=BaseEntity.class)
public class DemoappApplication {
	

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoappApplication.class, args);
	}
}



