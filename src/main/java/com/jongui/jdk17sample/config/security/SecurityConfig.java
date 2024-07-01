package com.jongui.jdk17sample.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Qualifier("CustomAuthenticationProvider")
    private AuthenticationProvider authenticationProvider;


    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChainCustom(HttpSecurity security) throws Exception {
        return security.securityMatcher("/**").csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                k -> k.requestMatchers("/**").permitAll()).build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChainForApi(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable).securityMatcher("/api/**").authorizeHttpRequests(k -> {
            k.requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("USER_READ", "API_ALL")
                    .requestMatchers("/api/user/**", "/api/user").hasAnyAuthority("USER_ALL", "API_ALL")
                    .requestMatchers("/api/**")
                    .hasAnyAuthority("ADMIN_ALL", "API_ALL")
                    .requestMatchers("/api/users/log").permitAll();
        }).authenticationProvider(authenticationProvider).exceptionHandling((s) -> {
            s.authenticationEntryPoint(new ApiAuthenticationEntryPoint());
            s.accessDeniedHandler(new ApiAccessDeniedHandler());
        }).build();
    }


//    @Bean
//    @Order(1)
//    public SecurityFilterChain securityFilterChainForApi(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.securityMatcher("/api/**")
//                .authorizeHttpRequests(k -> {
//
//                    k.requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("USER_READ", "API_ALL")
//                            .requestMatchers("/api/user/**").hasAnyAuthority("USER_ALL", "API_ALL")
//                            .requestMatchers("/api/**").hasAnyAuthority("ADMIN_ALL", "API_ALL");
//                })
//                .authenticationProvider(authenticationProvider).exceptionHandling((s) -> {
//                    s.authenticationEntryPoint(new ApiAuthenticationEntryPoint());
//                    s.accessDeniedHandler(new ApiAccessDeniedHandler());
//                }).build();
//    }

    @Bean
    @Order(3)
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers("/login", "/create", "/logout")
                            .permitAll()
                            .requestMatchers("/user", "/user/**")
                            .hasAnyAuthority("USER_ALL").anyRequest().authenticated();
                })

                .formLogin((s) -> s.loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                        .failureHandler(new LoginFailureHandler())
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/dashboard");
                        }).loginProcessingUrl("/login_process"))
                .logout((s) -> s.logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll())
                .authenticationProvider(authenticationProvider)
                .exceptionHandling((s) -> {
                    s.authenticationEntryPoint(new PageAuthenticationEntryPoint());
                    s.accessDeniedHandler(new PageAccessDeniedHandler());
                }).build();

    }
}
