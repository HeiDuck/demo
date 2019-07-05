package com.agilecontrol.robotorder.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;

import com.agilecontrol.robotorder.demo.utils.DbUtils;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

@SpringBootApplication
public class DemoApplication {
	public static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World");
		DbUtils.applicationContext = context;
		AmazonSQS sqs = DbUtils.getSQSClient();
		String queue_url = sqs.getQueueUrl("sqs_test").getQueueUrl();
		ReceiveMessageResult rmr = sqs.receiveMessage(queue_url);
		List<Message> message = rmr.getMessages();
		if(message == null || message.size() == 0) {
			logger.debug("没有可用消息");
		}else {
			logger.debug("可用消息为:" + message.get(0).getBody());
		}
		
		System.exit(0);
	    //sqs.deleteMessage(queue_url, message.getMessages().get(0).getReceiptHandle());
	}
}
