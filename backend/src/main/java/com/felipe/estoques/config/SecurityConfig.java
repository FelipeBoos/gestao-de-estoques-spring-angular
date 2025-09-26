package com.felipe.estoques.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**","/v3/api-docs/**","/api/v1/health").permitAll()
                        .anyRequest().authenticated()   // por enquanto mantém protegido
                )
                .httpBasic(Customizer.withDefaults()); // evita a senha gerada do user padrão
        return http.build();
    }
}