package com.agilecontrol.robotorder.demo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;


@Configuration
public class AmazonSQSConfiguration {
	@Value("${sqs_access_key}")
	private String access_key;
	
	@Value("${sqs_secret_key}")
	private String secret_key;
	
//	@Bean
//	public BasicAWSCredentials credentials() {
//		System.out.println(access_key);
//		System.out.println(secret_key);
//		BasicAWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
//		return credentials;
//	}
	
	//@Autowired
	@Bean
	public AmazonSQS sqsClient() {
		BasicAWSCredentials credentials = new BasicAWSCredentials(access_key, secret_key);
		System.out.println(credentials.getAWSAccessKeyId());
		AmazonSQSClientBuilder builder = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CN_NORTH_1);
		AmazonSQS sqs = builder.build();
		return sqs;
	}

	
	
}
