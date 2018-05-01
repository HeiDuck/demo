package com.agilecontrol.robotorder.demo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

import com.amazonaws.services.sqs.AmazonSQS;

public class DbUtils{
	public static ApplicationContext applicationContext;

	public static RedisConnection getConnection() {
		return applicationContext.getBean(RedisConnection.class);
	}
	
	public static AmazonSQS getSQSClient () {
		return applicationContext.getBean(AmazonSQS.class);
	}
}
