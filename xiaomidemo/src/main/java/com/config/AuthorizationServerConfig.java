package com.config;

import com.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
@PropertySource("classpath:oauth2.properties")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {   //配置的授权服务器
    @Value("${oauth.client}")
    private String client;
    @Value("${oauth.secret}")
    private String secret;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        //super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println(client+"    "+secret);
        clients.inMemory().withClient(client)
                .secret(secret)
                .resourceIds("rid")
                .scopes("all")
                .authorizedGrantTypes("password","refresh_token")
                .accessTokenValiditySeconds(60*60);//1个小时内有效
              //  .refreshTokenValiditySeconds();

      //  super.configure(clients);
    }
   @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //产生的令牌的
         endpoints
                 .authenticationManager(authenticationManager)
                 .userDetailsService(userDetailsService)
                 .tokenStore(new RedisTokenStore(redisConnectionFactory));//把产生的令牌token，存入到redis中
      //  super.configure(endpoints);
    }
}
