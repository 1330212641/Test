package com.config;


import com.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ();
        CorsConfiguration corsConfig = new CorsConfiguration ();
        corsConfig.setAllowCredentials( true);  // 允许携带 Authorization 头
        corsConfig.setAllowedOriginPatterns(Collections.singletonList("*"));   // 允许所有域，当请求头
        // corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setAllowedMethods(Collections.singletonList("*"));    // 允许所有请求方法
        corsConfig.setAllowedHeaders(Collections.singletonList("*")); // 允许全部请求头
        source.registerCorsConfiguration("/**", corsConfig);   // 允许全部请求路径
        return source;
    }
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
   }
   @Bean
    PasswordEncoder passwordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
   }


   //配置自定义的身份认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
        auth.userDetailsService(userDetailsService);
     //   auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //配置自定义的权限
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("asdfadsfadsfadsf Security");
          http.authorizeRequests()
                  .antMatchers("/oauth/**").permitAll()
                  .antMatchers("/oauth2/login").permitAll()
                  .anyRequest().authenticated()
                  .and().formLogin()
                  .loginProcessingUrl("/oauth2/login")
                  .and().cors().configurationSource(corsConfigurationSource())
                  .and().csrf().disable();

    }



}
