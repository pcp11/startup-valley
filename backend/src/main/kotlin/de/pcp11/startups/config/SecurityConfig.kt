package de.pcp11.startups.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun springWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .authorizeExchange { exchanges ->
                    exchanges.pathMatchers("/api/startups").permitAll()
                    exchanges.pathMatchers("/api/startup/**").permitAll()
                    exchanges.anyExchange().authenticated()
                }
                .httpBasic(withDefaults())
                .build();
    }
}