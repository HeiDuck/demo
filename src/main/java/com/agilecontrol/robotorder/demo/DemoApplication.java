package com.agilecontrol.robotorder.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

import com.agilecontrol.robotorder.demo.utils.DbUtils;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World 嘿嘿丫丫");
		DbUtils.applicationContext = context;
		RedisConnection connection = DbUtils.getConnection();
		String key = "usr:893:list";
		for(int i = 0;i < 100;i++) {
			List<byte[]> list = connection.bRPop(500, key.getBytes());
			System.out.println("key:" + new String(list.get(0)));
			System.out.println("value:" + new String(list.get(1)));
			Thread.sleep(2000);
		}
//		for(int i = 0;i < 100;i++) {
//			connection.lPush(key.getBytes(), new byte[] {(byte)i});
//		}
		
	}
}
