package com.bdg.dashboard;

import java.io.IOException;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.bdg.dashboard")
public class RabbitMqClient {

	public static final String topicExchangeName = "dashboard-exchange";

	public static final String queueName = "dashboard-queue";

	public static final String routeKey = "dashboard.route.estadooficina.*";
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Bean
	public ConnectionFactory connectionFactory() throws IOException {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		
		return connectionFactory;
	}

	/*@Bean
	public ConnectionFactory connectionFactory() throws IOException {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		Connection connection = connectionFactory.createConnection();
		Channel channel = connection.createChannel(true);

		// ConnectionFactory factory = new ConnectionFactory();
		// factory.setHost("localhost"); //Connection connection =
		factory.newConnection(); // Channel channel = connection.createChannel();

		channel.queueDeclare(queueName, false, false, false, null);
		return connectionFactory;
	}*/

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routeKey);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(convert());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter convert() {
		return new Jackson2JsonMessageConverter();
	}

	/*
	 * @Bean public RabbitTemplate rabbitTemplate(final ConnectionFactory
	 * connectionFactory) { final RabbitTemplate rabbitTemplate = new
	 * RabbitTemplate(connectionFactory);
	 * //rabbitTemplate.setMessageConverter(converter());
	 * rabbitTemplate.setRoutingKey(routeKey); return rabbitTemplate; }
	 * 
	 * @Bean public Jackson2JsonMessageConverter converter() { return new
	 * Jackson2JsonMessageConverter(); }
	 */

}
