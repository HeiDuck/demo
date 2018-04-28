package com.agilecontrol.robotorder.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

import com.agilecontrol.robotorder.demo.utils.DbUtils;

@SpringBootApplication
public class DemoApplication {
	public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World 嘿嘿丫丫");
		DbUtils.applicationContext = context;
		RedisConnection connection = DbUtils.getConnection();
		String key = "usr:893:list";
		long length = connection.lLen(key.getBytes());
//		while(length > 0) {
//			List<byte[]> list = connection.bRPop(500, key.getBytes());
//			logger.debug("key:" + new String(list.get(0)));
//			logger.debug("value:" + new String(list.get(1)));
//			Thread.sleep(2000);
//		}
		for(int i = 0;i < 100000;i++) {
			logger.debug("key--------------" + i);
			connection.lPush(key.getBytes(), String.valueOf(i).getBytes());
		}
	}
}
