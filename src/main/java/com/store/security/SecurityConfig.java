package com.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableWebMvc
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {

        this.customUserDetailsService = customUserDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder  = new MvcRequestMatcher.Builder(introspector).servletPath("/path");
        return http
                .csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/users/register/**", "/resource/**", "/webjars/**").permitAll()
                        .requestMatchers(mvcMatcherBuilder.pattern("/user")).hasAnyRole("ADMIN","USER")
                        .requestMatchers(mvcMatcherBuilder.pattern("/admin")).hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .formLogin(form -> form.loginPage("/users/login")
                        .loginProcessingUrl("/users/login")
                        .defaultSuccessUrl("/home")
                        .permitAll())
                .logout(LogoutConfigurer::permitAll)
                .userDetailsService(customUserDetailsService)
                .headers(headers->headers.frameOptions().sameOrigin())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
