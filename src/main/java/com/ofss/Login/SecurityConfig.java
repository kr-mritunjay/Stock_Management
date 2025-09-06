package com.ofss.Login;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll()  // allow login/signup without auth
                .anyRequest().authenticated()             // protect other endpoints
            )
            .formLogin(form -> form.disable()) // disable default login page
            .httpBasic(httpBasic -> httpBasic.disable()); // disable default basic auth

        return http.build();
    }
}

