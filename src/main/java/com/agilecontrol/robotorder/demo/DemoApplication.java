package com.agilecontrol.robotorder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.agilecontrol.robotorder.demo.utils.DbUtils;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World 嘿嘿丫丫");
		DbUtils.applicationContext = context;
		DbUtils.getConnection().set("usr:893".getBytes(), "893".getBytes());
	}
}
