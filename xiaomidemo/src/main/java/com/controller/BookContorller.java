package com.controller;

import com.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class BookContorller {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test1")
        public HashMap<String,Object> test1(){
            HashMap<String, Object> hashMap = new HashMap<>();
            ValueOperations<String,String> opsl = stringRedisTemplate.opsForValue() ;opsl.set(" name","三国演义");
            String bname = opsl.get ("name") ;
            System.out.println(bname) ;
            ValueOperations ops2 = redisTemplate.opsForValue();
            Book b = new Book();
            b.setId(1) ;
            b.setName("红楼梦");
            b.setAuthor("曹雪芹");
            ops2.set("b1", b);
            Book b1 = (Book) ops2.get("b1");
            System. out. println(b1.getId());
            hashMap.put ("code", 200);
            hashMap.put("msg","添加成功");
           return hashMap;
    }
}
