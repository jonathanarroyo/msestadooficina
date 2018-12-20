/**
 * 
 */
package com.bdg.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * @author programador
 * @date 5/12/2018
 * @description Configuracion del Mongo DB
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.bdg.dashboard.repository")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.bdg.dashboard.controller")
//@EnableWebMvc
public class MongoConfig extends AbstractMongoConfiguration {

	@Autowired
	private Environment env;
	
	@Override
	public MongoClient mongoClient() {
		return new MongoClient(env.getProperty("spring.data.mongodb.host"), 
				Integer.parseInt(env.getProperty("spring.data.mongodb.port")));
	}

	@Override
	protected String getDatabaseName() {
		return env.getProperty("spring.data.mongodb.database");
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.bdg.dashboard.model";
	}

}
