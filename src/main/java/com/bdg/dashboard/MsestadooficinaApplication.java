package com.bdg.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MsestadooficinaApplication extends SpringBootServletInitializer {

	/*public static final String topicExchangeName = "dashboard-exchange";

	public static final String queueName = "dashboard-queue";

	public static final String routeKey = "dashboard.route.estadooficina.*";

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
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MsestadooficinaApplication.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MsestadooficinaApplication.class);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public AutowireHelper autowireHelper() {
		return AutowireHelper.getInstance();
	}
}
