package com.agilecontrol.robotorder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

import com.agilecontrol.robotorder.demo.utils.DbUtils;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World 嘿嘿丫丫");
		DbUtils.applicationContext = context;
		RedisConnection connection = DbUtils.getConnection();
		int i = 0;
		String key = "usr:893";
		while(true) {
			key = key + i;
			System.out.println("redis 设置值 key:" + key);
			connection.set(key.getBytes(), String.valueOf(i++).getBytes());
			System.out.println("redi usr:893对应的值:" + connection.get(key.getBytes()));
		}
		
	}
}
