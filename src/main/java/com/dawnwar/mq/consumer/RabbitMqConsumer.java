package com.dawnwar.mq.consumer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


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
		JSONObject result = null;
		try {
			result = JSON.parseObject(message);
		} catch (Exception e) {
			log.error("Fail to parse spider message:{}", message, e);
			return;
		}
		if (result == null) {
			log.error("RabbitMQ User message is null");
			return;
		}
		//解析result
		//.....
		
	}
	
	
}
