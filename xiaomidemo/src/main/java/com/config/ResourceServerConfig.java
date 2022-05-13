package com.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {//资源服务器

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        System.out.println("asdfadsfadsfadsf resourceServerConfig");
      //验证token--->check_token
        resources.resourceId("rid").stateless(true);
        resources.accessDeniedHandler(new AccessDeniedHandler() {   //无权限
            @Override
            public void handle(HttpServletRequest request,
                               HttpServletResponse response,
                               AccessDeniedException accessDeniedException) throws IOException, ServletException {
                response.setHeader("Content-Type", "application/json;charset=UTF-8");
                System.out.println("无权限");
                HashMap<String,Object> map = new HashMap<>();
                map.put("code",400);
                map.put("msg","无权限");

                JSONObject.writeJSONString(response.getWriter(),map);
            }
        });
        //无效token
        resources.authenticationEntryPoint((request, response, authException) -> {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            HashMap<String,Object> map = new HashMap<>();
            map.put("code",400);
            map.put("msg","无效token");
            JSONObject.writeJSONString(response.getWriter(),map);
        });
    }
    @Autowired
    CorsConfigurationSource corsConfigurationSource;
    @Override
    public void configure(HttpSecurity http) throws Exception {  //资源，
        http.authorizeRequests()
                .antMatchers("/oauth2/getInfo").hasAnyRole("root","usersAdmin","goodsAdmin")
                .antMatchers("/user/**").hasAnyRole("root","usersAdmin")
                //表示root、usersAdmin两个角色可以访问/user/**
                .antMatchers("/goods/**").hasAnyRole("root","goodsAdmin")
                .antMatchers("/oauth2/login").permitAll()  //不需要带token
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource)
                .and().csrf().disable();





    }
}
