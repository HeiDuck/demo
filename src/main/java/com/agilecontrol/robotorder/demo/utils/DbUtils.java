package com.agilecontrol.robotorder.demo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

public class DbUtils{
	public static ApplicationContext applicationContext;

	public static RedisConnection getConnection() {
		return applicationContext.getBean(RedisConnection.class);
	}
}
