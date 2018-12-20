/**
 * 
 */
package com.bdg.dashboard;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

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

	private final Logger log = LoggerFactory.getLogger(MongoConfig.class);
	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private Integer port;
	@Value("${spring.data.mongodb.username}")
	private String username;
	@Value("${spring.data.mongodb.database}")
	private String database;
	@Value("${spring.data.mongodb.password}")
	private String password;

	@Autowired
	private Environment env;

	@Override
	public MongoClient mongoClient() {
		return new MongoClient(Collections.singletonList(new ServerAddress(host, port)),
				Collections.singletonList(MongoCredential.createCredential(username, database, password.toCharArray())));

		//return new MongoClient(host, port);
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
