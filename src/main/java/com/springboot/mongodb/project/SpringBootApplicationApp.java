package com.springboot.mongodb.project;

import com.springboot.mongodb.project.model.Endereco;
import com.springboot.mongodb.project.repository.TutorialRepository;
import com.springboot.mongodb.project.service.ViaCEPClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableFeignClients
@EnableMongoRepositories(basePackageClasses = 	TutorialRepository.class)
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,
		MongoReactiveAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class})
public class SpringBootApplicationApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationApp.class, args);
	}

}
