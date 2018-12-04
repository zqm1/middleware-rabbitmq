package com.pc.test.RabbitMQ_Learn;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQctl {
public static void main(String[] args) {
	
}
public ConnectionFactory connection() {
	ConnectionFactory connectionFactory=new ConnectionFactory();
	connectionFactory.setHost("");
	connectionFactory.setPort(0);
	connectionFactory.setUsername("");
	connectionFactory.setPassword("");
	return null;
	
}
}
