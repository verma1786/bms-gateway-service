package com.gateway.bms.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        log.info("[GatewayConfig : routes(RouteLocatorBuilder builder)");
        return builder.routes()
                .route(p -> p
                        .path("/user/**")
                        .filters(f -> f.addRequestHeader("X-USER-HEADER", "USER-VALUE")
                        .circuitBreaker(config -> config
                                .setName("BMS-USER-SERVICE-001")
                                .setFallbackUri("forward:/userService")))
                        .uri("lb://BMS-USER-SERVICE")
                        .id("BMS-USER-SERVICE-001"))
                .build();
    }

}


   /* @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        log.info("[GatewayConfig : routes(RouteLocatorBuilder builder)");
        return builder.routes()
            .route("PSA-AUTH-SERVICE", r -> r
                .path("/auth/**")
                .filters(f -> f
                    .filter(filter)
                    .circuitBreaker(config -> config
                        .setName("PSA-AUTH-SERVICE")
                        .setFallbackUri("forward:/psaAuthService")))
                .uri("lb://PSA-AUTH-SERVICE"))

            .route("PSA-USERMENU-SERVICE", r -> r
                .path("/psa-usermenu/**")
                .filters(f -> f
                    .filter(filter)
                    .circuitBreaker(config -> config
                        .setName("PSA-USERMENU-SERVICE")
                        .setFallbackUri("forword/psaUserMenuService")))
                .uri("lb://PSA-USERMENU-SERVICE"))

            .route("PSA-MASTER-SERVICE", r -> r
                .path("/psa-master/**")
                .filters(f -> f
                    .filter(filter)
                    .circuitBreaker(config -> config
                        .setName("PSA-MASTER-SERVICE")
                        .setFallbackUri("forward:/masterService")))
                .uri("lb://PSA-MASTER-SERVICE"))

                .route("PSA-COMMUNITY-SERVICE", r -> r
                        .path("/psa-community/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-COMMUNITY-SERVICE")
                                        .setFallbackUri("forward:/communityService")))
                        .uri("lb://PSA-COMMUNITY-SERVICE"))

                .route("PSA-FILE-SERVICE", r -> r
                        .path("/psa-file/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-FILE-SERVICE")
                                        .setFallbackUri("forward/fileService")))
                        .uri("lb://PSA-FILE-SERVICE"))

	        .route("PSA-LOST-SERVICE", r -> r
                        .path("/psa-lost/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-LOST-SERVICE")
                                        .setFallbackUri("forward/lostService")))
                        .uri("lb://PSA-LOST-SERVICE"))

                .route("PSA-DIGI-LOCKER-SERVICE", r -> r
                        .path("/digi-locker/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-DIGI-LOCKER-SERVICE")
                                        .setFallbackUri("forward/digiService")))
                        .uri("lb://PSA-DIGI-LOCKER-SERVICE"))
                .route("PSA-VERIFICATION-SERVICE", r -> r
                        .path("/psa-verification/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-VERIFICATION-SERVICE")
                                        .setFallbackUri("forward/verificationService")))
                        .uri("lb://PSA-VERIFICATION-SERVICE"))
		       .route("PSA-SMS-SERVICE", r -> r
                        .path("/sms/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-SMS-SERVICE")
                                        .setFallbackUri("forward/smsService")))
                        .uri("lb://PSA-SMS-SERVICE"))
		        .route("PSA-VISITOR-SERVICE", r -> r
                        .path("/psa-visitor/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-VISITOR-SERVICE")
                                        .setFallbackUri("forward/visitorService")))
                        .uri("lb://PSA-VISITOR-SERVICE"))

                .route("PSA-TEST-SERVICE", r -> r
                        .path("/PSA-TEST-SERVICE/**")
                        .filters(f -> f
                                .filter(filter)
                                .circuitBreaker(config -> config
                                        .setName("PSA-TEST-SERVICE")
                                        .setFallbackUri("forward/testService")))
                        .uri("lb://PSA-TEST-SERVICE"))
                .build();
    }
}



*/