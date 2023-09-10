package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;

@TestConfiguration(proxyBeanMethods = false)
public class MyContainersConfiguration {

	@Bean
	@ServiceConnection
	public PostgreSQLContainer<?> postgreSQLContainer() {
		return new PostgreSQLContainer<>("postgres:16rc1");
	}

//	@Bean
//	@ServiceConnection
//	public RabbitMQContainer rabbitMQContainer() {
//		return new RabbitMQContainer("rabbitmq:3-management");
//	}

}