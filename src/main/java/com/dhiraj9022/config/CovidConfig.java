package com.dhiraj9022.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CovidConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
