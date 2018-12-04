package com.pc.test.RabbitMQTest;

import org.junit.Test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SendMQ {
	private static final String QUEUE_NAME="QUEUE_simple";
	@Test
	public void sendMsg() throws Exception {
	/* 获取一个连接 */
	Connection connection = ConnectionUtils.getConnection();
	/*从连接中创建通道*/
	Channel channel = connection.createChannel();
	//创建队列 (声明) 因为我们要往队列里面发送消息,这是后就得知道往哪个队列中发送,就好比在哪个管子里面放水
	boolean durable=false;
	boolean exclusive=false;
	boolean autoDelete=false;
	channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, null);//如果这个队列不存在,其实这句话是不需要的
	
	String msg="Hello Simple QUEUE !";
	AMQP.BasicProperties.Builder builder=new Builder();
	//第一个参数是exchangeName(默认情况下代理服务器端是存在一个""名字的exchange的,
	 //因此如果不创建exchange的话我们可以直接将该参数设置成"",如果创建了exchange的话
	//我们需要将该参数设置成创建的exchange的名字),第二个参数是路由键
	channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
	System.out.println("---------send ms :"+msg);
	channel.close();
	connection.close();
	}

}
