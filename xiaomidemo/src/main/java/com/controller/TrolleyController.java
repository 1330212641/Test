package com.controller;

import com.pojo.Trolley;
import com.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
@CrossOrigin
@RestController
public class TrolleyController implements Serializable {
    @Autowired
    TrolleyService trolleyService;
    @GetMapping("/showCart")
    public HashMap<String,Object> getCarts(Integer uid){
        List<HashMap<String, Object>> list = this.trolleyService.getCarts(uid);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(list!=null){
            hashMap.put("code",200);
            hashMap.put("msg","成功");
            hashMap.put("row",list);
            hashMap.put("total",list.size());
            return hashMap;
        }
        hashMap.put("code",401);
        hashMap.put("msg","获取失败");
        return hashMap;

    }

//    @PostMapping("/updateGoodsNumber")
//    public HashMap<String,Object> updateGoodsNumber(Trolley trolley){//传过来的是json对象
//        int i = this.trolleyService.updateGoodsNumber(trolley);
//        HashMap<String ,Object> hashMap=new HashMap<>();
//        if(i>0){
//            hashMap.put("code",200);
//            hashMap.put("msg","成功");
//
//            return hashMap;
//        }
//        hashMap.put("code",401);
//        hashMap.put("msg","获取失败");
//        return hashMap;
//
//    }

    @GetMapping("/deleteGoodsNumber")
    public HashMap<String,Object> deleteGoodsNumber(int[] tids){//传过来的是json对象
        int i = this.trolleyService.allDetele(tids);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("msg","成功");

            return hashMap;
        }
        hashMap.put("code",401);
        hashMap.put("msg","获取失败");
        return hashMap;

    }

    @PostMapping("/addTrolley")
    public HashMap<String,Object> addTrolley(Trolley trolley,String yemian){//传过来的是json对象
//        trolley.setOrdersNumber("");
        int i = this.trolleyService.insertTrolley(trolley,yemian);
        System.out.println(yemian);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("total",i);
            hashMap.put("msg","成功");

            return hashMap;
        }
        hashMap.put("code",401);
        hashMap.put("msg","获取失败");
        return hashMap;

    }
    @GetMapping("/getCount")
    public HashMap<String,Object> getCount(Integer uid){
        int i = trolleyService.gouwuchecount(uid);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("msg","成功");
            hashMap.put("count",i);
            return hashMap;
        }
        hashMap.put("code",401);
        hashMap.put("msg","获取失败");
        return hashMap;
    }
}
