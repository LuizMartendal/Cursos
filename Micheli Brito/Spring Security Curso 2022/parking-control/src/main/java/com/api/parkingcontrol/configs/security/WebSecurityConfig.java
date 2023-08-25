package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests((auth) ->
                        auth
                            .requestMatchers(antMatcher(HttpMethod.GET, "/parking-spot/**")).permitAll()
                            .requestMatchers(antMatcher(HttpMethod.POST, "/user")).permitAll()
                            .requestMatchers(antMatcher(HttpMethod.DELETE, "/parking-spot/**")).hasRole("ROLE_ADMIN")
                            .anyRequest().authenticated()
                )
                .csrf().disable();
        return http.build();
    }
}
