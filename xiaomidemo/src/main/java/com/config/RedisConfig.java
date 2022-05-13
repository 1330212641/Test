package com.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> template=new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jacksonSeial=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om=new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);
        template.setDefaultSerializer(jacksonSeial);
        return template;
    }
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
//        RedisSerializer<String> strSerializer=new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jacksonSeial=new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om=new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jacksonSeial.setObjectMapper(om);
//        RedisCacheConfiguration config=RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofDays(1))
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(strSerializer))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jacksonSeial))
//                .disableCachingNullValues();
//        RedisCacheManager cacheManager=RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config).build();
//        return cacheManager;
//    }
}
