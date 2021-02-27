package com.padawans.framework.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

   private String apiUrl;

   public BeanConfiguration(ApiConfiguration apiConfiguration){
       this.apiUrl = apiConfiguration.apiBaseUrl;
   }

   @Bean
   public WebClient webClient(WebClient.Builder builder) {
       return builder.baseUrl(apiUrl).defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
   }
}