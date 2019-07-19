package org.ajou.realcoding.weathercrawler.Lolrecodesearch.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    @Bean
    public MongoTemplate createMongoTemplate() {
        return new MongoTemplate(new MongoClient(), "LoL-record");
    }
}