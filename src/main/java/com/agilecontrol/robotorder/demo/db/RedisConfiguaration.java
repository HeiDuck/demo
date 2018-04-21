package com.agilecontrol.robotorder.demo.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfiguaration {

	@Bean
	public RedisConnection connection(RedisConnectionFactory jedisConnectionFactory) {
		RedisConnection connection = jedisConnectionFactory.getConnection();
		return connection;
	}

	@Bean
	public RedisConnectionFactory jedisConnectionFactory(RedisPassword password) {

		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setDatabase(database);
		redisStandaloneConfiguration.setHostName(hostName);
		redisStandaloneConfiguration.setPassword(password);
		redisStandaloneConfiguration.setPort(port);
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
		return jedisConnectionFactory;
	}

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.host}")
	private String hostName;

	@Bean
	@Value("${spring.redis.password}")
	public RedisPassword getPassword(String password) {
		RedisPassword redisPassword = RedisPassword.of(password);
		return redisPassword;
	}

	@Value("${spring.redis.port}")
	private int port;
}
