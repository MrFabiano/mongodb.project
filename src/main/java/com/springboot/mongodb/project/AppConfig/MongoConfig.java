package com.springboot.mongodb.project.AppConfig;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    public static final String MONGODB_CONNECT = "mongodb+srv://%s:%s@%s";

    @Value("${mongodb.username}")
    private String username;
    @Value("${mongodb.password}")
    private String password;
    @Value("${mongodb.host}")
    private String host;


    @Override
    protected String getDatabaseName() {
        return "mongodb";
    }
    
 
    @Bean
    public MongoClient mongoClient(){
        //ConnectionString connectionString = new ConnectionString("mongodb+srv://mongodbjavaspring05:CASA_JAVA@cluster0.fzg9tyo.mongodb.net");
        ConnectionString connectionString = new ConnectionString(String.format(MONGODB_CONNECT, username, password, host));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    public Collection<String> getMappingBasePackges(){
        return Collections.singleton("tutorials");
    }
}

