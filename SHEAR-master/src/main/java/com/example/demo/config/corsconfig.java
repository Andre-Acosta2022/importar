package com.example.demo.config;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.hibernate.annotations.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.validation.constraints.Pattern;

@Configuration
public class corsconfig {
@Bean
CorsConfigurationSource corsConfigurationSource() {
CorsConfiguration configuration= new CorsConfiguration();
configuration.setAllowCredentials(true);
configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
configuration.setAllowedHeaders(Arrays.asList("*"));
UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
source.registerCorsConfiguration("/**", configuration);
return source;
}
}
