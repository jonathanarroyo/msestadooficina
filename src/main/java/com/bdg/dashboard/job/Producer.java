package com.bdg.dashboard.job;

import java.util.concurrent.CompletableFuture;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.bdg.dashboard.RabbitMqClient;
import com.bdg.dashboard.model.CustomMessage;

@Component
public class Producer {

	//private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private final RabbitTemplate rabbitTemplate;
	
	public Producer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
    
   
	@SuppressWarnings("rawtypes")
	public void sendMessage(CustomMessage mensaje) {    	    
    	System.out.println("Enviando mensaje... " + mensaje);
		CompletableFuture.runAsync(() ->
		rabbitTemplate.convertAndSend(RabbitMqClient.topicExchangeName, RabbitMqClient.routeKey , mensaje));
    }
    
   
}
