package com.JavaWeb.HotelManagementSystem.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(c -> c.disable())
        .authorizeHttpRequests(request -> request.requestMatchers("/admin-page")
        .hasAuthority("ADMIN").requestMatchers("/user-page").hasAuthority("USER")
        .requestMatchers("/registration", "/css/**","/budgetRest/**","/eventRest/**","/activityRest/**","/taskRest/**","/contactRest/**","/budget/**","/expense/**","/userRest/**").permitAll()
        .requestMatchers("/image/**").permitAll()
        .requestMatchers("/login", "/register","/home", "/css/*", "/js/*").permitAll()
        .anyRequest().authenticated())

            .formLogin(formLogin -> formLogin
                .loginPage("/login.html")
                .permitAll()
            )
            ;
        return http.build();
    }
}
