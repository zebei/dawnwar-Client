package com.dawnwar.mq.producer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class RabbitMqProducer {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.userqueue}")
	private String userqueue;
	
	public void send(String message) {
		
		log.info("Sender : " + message);
		this.rabbitTemplate.convertAndSend(userqueue, message);
	}
	

}
