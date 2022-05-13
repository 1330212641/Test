package com.example.xiaomidemo;

import com.mapper.GoodsMapper;
import com.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XiaomidemoApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void show(){
        List<Goods> list= goodsMapper.showGoodsByState(4);
        for(Goods g:list){
            System.out.println(g);
        }
    }

}
