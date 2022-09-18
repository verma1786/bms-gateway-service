package com.gateway.bms.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
@Slf4j
public class URIConfiguration extends CorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {

        final CorsConfiguration coresConfig = new CorsConfiguration();
        coresConfig.setAllowedOrigins(List.of("*"));
        coresConfig.setMaxAge(3600L);
        coresConfig.addAllowedMethod("*");
        coresConfig.addAllowedHeader("*");

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", coresConfig);

        return new CorsWebFilter(source);
    }
}

