package com.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@EnableConfigurationProperties
@ComponentScan(basePackages = "com.sms")
@SpringBootApplication
public class Sms1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sms1Application.class, args);
	}
}
