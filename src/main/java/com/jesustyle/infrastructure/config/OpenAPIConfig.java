//package com.jesustyle.infrastructure.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springdoc.core.GroupedOpenApi;
//
//@Configuration
//public class OpenAPIConfig {
//
//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("public-apis")
//                .pathsToMatch("/usuario/**", "/pagamento/**", "/produto/**")
//                .build();
//    }
//}