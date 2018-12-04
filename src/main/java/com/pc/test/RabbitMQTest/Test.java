package com.pc.test.RabbitMQTest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Test {
	private final static String QUEUE_NAME = "test_queue_work";

	public static void main(String[] args) throws Exception {
		/*SendMQ mq=new SendMQ();
		mq.sendMsg();*/
		Connection connection=ConnectionUtils.getConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		for (int i = 0; i < 50; i++) {
			// 消息内容
			String message = "." + i;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
			Thread.sleep(i * 10);
			}
			channel.close();
			connection.close();	
	}

}
