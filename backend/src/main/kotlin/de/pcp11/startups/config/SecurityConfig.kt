package de.pcp11.startups.config

import de.pcp11.startups.jwt.JwtUtil
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.AuthenticationWebFilter
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun jwtAuthenticationConverter(): ServerAuthenticationConverter {
        return ServerAuthenticationConverter { exchange ->
            Mono.justOrEmpty(exchange)
                    .flatMap { Mono.justOrEmpty(it.request.cookies["X-Auth"]) }
                    .filter { it.isNotEmpty() }
                    .map { it[0].value }
                    .map { UsernamePasswordAuthenticationToken(it, it) }
        }
    }

    @Bean
    fun jwtAuthenticationManager(jwtUtil: JwtUtil): ReactiveAuthenticationManager {
        return ReactiveAuthenticationManager { authentication ->
            Mono.justOrEmpty(authentication)
                    .map { jwtUtil.validateJwt(it.credentials as String) }
                    .map { jws ->
                        UsernamePasswordAuthenticationToken(
                                jws.body.subject,
                                authentication.credentials as String,
                                mutableListOf(SimpleGrantedAuthority("ROLE_USER"))
                        )
                    }
        }
    }

    @Bean
    fun springWebFilterChain(http: ServerHttpSecurity,
                             jwtAuthenticationManager: ReactiveAuthenticationManager,
                             jwtAuthenticationConverter: ServerAuthenticationConverter): SecurityWebFilterChain {
        val authenticationWebFilter = AuthenticationWebFilter(jwtAuthenticationManager)
        authenticationWebFilter.setServerAuthenticationConverter(jwtAuthenticationConverter)

        return http
                .exceptionHandling()
                .authenticationEntryPoint { swe, _ -> { swe.response.setStatusCode(HttpStatus.UNAUTHORIZED) }.toMono().then() }
                .accessDeniedHandler { swe, _ -> { swe.response.setStatusCode(HttpStatus.FORBIDDEN) }.toMono().then() }
                .and()
                .authorizeExchange { exchanges ->
                    exchanges.pathMatchers("/", "/index.html", "/static/**").permitAll()
                    exchanges.pathMatchers("/api/startups").permitAll()
                    exchanges.pathMatchers("/api/startup/**").permitAll()
                    exchanges.pathMatchers("/api/secured/**").authenticated()
                    exchanges.pathMatchers("/api/auth/**").permitAll()
                    exchanges.anyExchange().authenticated()
                }
                .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .build()
    }
}