package com.song.course.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@Configuration
@ComponentScan(basePackages = {"com.song.course"})
@EnableNeo4jRepositories(
        basePackages = "com.song.course.repository")
public class DataBaseConfig implements AutoCloseable {
    @Bean
    public EmbeddingModel embeddingModel() {
        // Configure your OpenAI API key (e.g., from application.properties)
        // Ensure you have the 'spring.ai.openai.api-key' property set
        return new OpenAiEmbeddingModel();
    }
    public Driver driver;
    
    //@Bean
    public Driver connectionNeo4j() {
        return driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "12345678"));
    }
    
    public static final String URL =
            System.getenv("NEO4J_URL") != null ?
                    System.getenv("NEO4J_URL") : "bllolt://localhost:7687";
    
    @Override
    public void close() throws Exception {
        driver.close();
    }
}
