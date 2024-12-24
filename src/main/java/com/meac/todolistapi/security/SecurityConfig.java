package com.meac.todolistapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/h2-console/**").permitAll()
                            .requestMatchers("/register").permitAll()
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("todos/**").authenticated()
                            .anyRequest().authenticated()
                    )
                    .csrf(csrf -> csrf
                            .ignoringRequestMatchers("/h2-console/**")
                            .ignoringRequestMatchers("/user/**")
                            .ignoringRequestMatchers("/register/**")
                            .ignoringRequestMatchers("/login/**")
                    )
                    .headers(headers -> headers
                            .frameOptions(frameOptions -> frameOptions.sameOrigin())
                    );

            return http.build();
        }
    }


