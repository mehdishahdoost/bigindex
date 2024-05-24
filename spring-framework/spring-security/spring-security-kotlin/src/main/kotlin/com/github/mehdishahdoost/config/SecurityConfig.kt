package com.github.mehdishahdoost.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun userDetailsService(encoder: PasswordEncoder): MapReactiveUserDetailsService {
        val user = User.builder().username("mehdi").password(encoder.encode("mehdi")).roles("USER").build()
        return MapReactiveUserDetailsService(user)
    }

    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.authorizeExchange().pathMatchers(HttpMethod.POST, "/login").permitAll()
            .anyExchange().authenticated().and().httpBasic().disable().csrf().disable()
        return http.build()
    }

}