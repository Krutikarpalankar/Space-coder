package com.spacecoder.coding.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class Judge0Config {

    @Value("${judge0.base-url}")
    private String judge0BaseUrl;

    @Bean
    public RestClient judge0RestClient() {

        return RestClient.builder()
                .baseUrl(judge0BaseUrl)
                .build();
    }
}