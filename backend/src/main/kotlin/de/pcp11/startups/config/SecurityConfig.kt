package de.pcp11.startups.config

import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun springWebFilterChain(http: ServerHttpSecurity,
                             jwtAuthenticationManager: ReactiveAuthenticationManager,
                             jwtAuthenticationConverter: ServerAuthenticationConverter): SecurityWebFilterChain {
        val authenticationWebFilter = AuthenticationWebFilter(jwtAuthenticationManager)
        authenticationWebFilter.setServerAuthenticationConverter(jwtAuthenticationConverter)

        return http
                .authorizeExchange { exchanges ->
                    exchanges.pathMatchers("/api/startups").permitAll()
                    exchanges.pathMatchers("/api/startup/**").permitAll()
                    exchanges.pathMatchers("/api/auth/**").permitAll()
                    exchanges.anyExchange().authenticated()
                }
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .build();
    }
}