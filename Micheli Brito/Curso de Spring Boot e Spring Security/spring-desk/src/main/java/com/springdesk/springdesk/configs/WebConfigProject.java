package com.springdesk.springdesk.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class WebConfigProject {

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers(antMatcher(HttpMethod.POST, "/cliente/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET, "/tecnico/**")).permitAll()
                    .anyRequest().authenticated()
                ).csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
