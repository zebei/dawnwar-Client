package com.dawnwar.mq.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class RabbitMqConsumer {
	

	
	/**
	 * 外站商品消息消费
	 * @param message
	 */
	@RabbitListener(queues="${spring.rabbitmq.userqueue}")
	public void receiveUser(String message) {
		log.debug("userqueue Consumer begin ..........");
		try {
//			result = message;
			log.info(message);
		} catch (Exception e) {
			log.error("Fail to parse spider message:{}", message, e);
			return;
		}
//		if (result == null) {
//			log.error("RabbitMQ User message is null");
//			return;
//		}
		//解析result
		//.....
		
	}
	
	
}
