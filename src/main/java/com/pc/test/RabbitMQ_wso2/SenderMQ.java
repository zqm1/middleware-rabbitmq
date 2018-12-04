package com.pc.test.RabbitMQ_wso2;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SenderMQ {
	private static final String QUEUE_NAME="QUEUE_simple";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection=ConnectionUtil.wso2connection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		channel.exchangeDeclare("amq.direct", "direct", true);
		channel.queueBind(QUEUE_NAME, "amq.direct", "");
		String msg = "{'test':'123'}";
		JSONObject jsonObject = new JSONObject();
		String sendmsg=jsonObject.parse(msg).toString();
		AMQP.BasicProperties.Builder builder=new Builder();
		builder.messageId("1223z");
		builder.contentType("text/plain");
		builder.replyTo("zqm");
		builder.correlationId("2233z");
		builder.contentEncoding("utf-8");
		HashMap<String, Object> header=new HashMap<String,Object>();
		header.put("SOAP_ACTION", "greet");
		builder.headers(header);
		
		channel.basicPublish("amq.direct", QUEUE_NAME, builder.build(),sendmsg.getBytes());
	}
}
