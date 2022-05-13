package com.controller;

import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth2")
public class OauthController {
    @Value("${oauth.client}")
    private String client;
    @Value("${oauth.secret}")
    private String secret;
    @Value("${oauth.postUrl}")
    private String postUrl;
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public HashMap<String,Object> ogin(String username, String password){   //   http://localhost:9000/oauth/token-->产生令牌
        HashMap<String,Object> map = new HashMap<>();
        System.out.println("username"+username+"  "+password);
        try{
            MultiValueMap<String,Object> data=new LinkedMultiValueMap<>();
            data.set("username",username);
            data.set("password",password);
            data.set("grant_type","password");
            map.put("code",200);
            map.put("msg","成功");
            System.out.println("username1111111111111"+username+"  "+password);
            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(client,secret));
            map.put("data",restTemplate.postForObject(postUrl, data, OAuth2AccessToken.class));
            System.out.println("登录成功返回的数据"+restTemplate.postForObject(postUrl, data, OAuth2AccessToken.class));
        }catch (Exception e){
            System.out.println(e.toString());
            map.put("code",400);
            map.put("msg","登录失败");
        }
        return map;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/getInfo")
    public Map<String,Object> getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
       // User member = (User) authentication.getPrincipal();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",authentication.getPrincipal());
        return  map;
    }


}
