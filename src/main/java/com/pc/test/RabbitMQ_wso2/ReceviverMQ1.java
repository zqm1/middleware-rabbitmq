package com.pc.test.RabbitMQ_wso2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class ReceviverMQ1 {
	private static final String queuename="QUEUE_simple";
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		Connection connection=ConnectionUtil.wso2connection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(queuename, true, false, false, null);
		channel.exchangeDeclare("amq.direct", "direct", true);
		channel.queueBind(queuename, "amq.direct", "");
		QueueingConsumer consumer=new QueueingConsumer(channel);
		channel.basicConsume(queuename,true,consumer);
		while(true){
			QueueingConsumer.Delivery delivery=consumer.nextDelivery();
			
			System.out.println(delivery.getProperties()+"sddddddddddd");
			String message=new String(delivery.getBody());
			System.out.println(message+"=sssssssssss");
		}
	}
}
