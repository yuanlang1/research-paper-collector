package com.yl.paperservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author yl
 * @date 2025-11-06 21:02
 */
@Configuration
public class WebClientConfig {
    @Value("${arxiv.api}")
    private String baseUrl;
    @Bean
    public WebClient arxivWebClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}

