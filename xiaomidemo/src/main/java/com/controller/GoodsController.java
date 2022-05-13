package com.controller;
import com.pojo.Goods;
import com.pojo.User;
import com.service.GoodsService;
import com.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @GetMapping("/getGoodsByState")
    public HashMap<String, Object> getGoodsByState(Integer state) {
        System.out.println(state + "控制器");
        List<Goods> list = goodsService.getGoodsByState(state);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("total", list.size());
        map.put("data", list);
        return map;
    }
    @GetMapping("/getGoodsZlanmu")
    public HashMap<String, Object> getGoodsByZlanmu(String zlanmu) {
        System.out.println(zlanmu);
        List<Goods> list = goodsService.getGoodsByzlanmu(zlanmu);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("total", list.size());
        map.put("data", list);
        return map;
    }
    @GetMapping("/detail/{gid}")
    public HashMap<String, Object> getGoodsBygid(@PathVariable("gid") Integer gid) {
        System.out.println(gid);
        Goods goodsBygid = this.goodsService.getGoodsBygid(gid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("data",goodsBygid);
        return map;
    }
    @PostMapping("/showAllgoods")
    public HashMap<String, Object> showAllgoods(){
        HashMap<String, Object> map = new HashMap<>();
        List<Goods> list = goodsService.showAllgoods();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("rows", list);
        return map;
    }
    @GetMapping("/deleteGood")
    public HashMap<String,Object> deleteGood(Integer gid){
        int i = this.goodsService.deleteGoods(gid);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("total",i);
            hashMap.put("msg","成功");
            return hashMap;
        }
        hashMap.put("code",500);
        hashMap.put("msg","失败");
        return hashMap;
    }
    @PostMapping("/deleteGoods")
    public HashMap<String ,Object> deleteGoods(@RequestBody List<Integer> gids){
        System.out.println(gids.size());
        int i = this.goodsService.deleteGood(gids);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("total",i);
            hashMap.put("msg","成功");
            return hashMap;
        }
        hashMap.put("code",500);
        hashMap.put("msg","失败");
        return hashMap;
    }
    @PostMapping("/addGoods")
    public HashMap<String ,Object> addGoods(Goods goods,HttpServletRequest request){
        Date date=new Date();
        Timestamp d=new Timestamp(date.getTime());
        goods.setProductDate(d);
        HashMap<String ,Object> hashMap=new HashMap<>();
        HttpSession session= request.getSession(true);
        int i = this.goodsService.addGoods(goods);
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("total",i);
            hashMap.put("msg","成功");
            return hashMap;
        }
        hashMap.put("code",500);
        hashMap.put("msg","失败");
        return hashMap;
    }
    @GetMapping("/updateState")
    public HashMap<String ,Object> updateState(Integer gid,Integer state){

        int i = this.goodsService.updateState(gid, state);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("total",i);
            hashMap.put("msg","成功");
            return hashMap;
        }
        hashMap.put("code",500);
        hashMap.put("msg","失败");
        return hashMap;
    }
    @PostMapping("/updateGoods")
    public HashMap<String ,Object> updateGoods(Goods goods){
        int i = this.goodsService.updateGoods(goods);
        HashMap<String,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("msg","成功");
            hashMap.put("total",i);
            return hashMap;
        }
        hashMap.put("code",500);
        hashMap.put("msg","失败");
        return hashMap;
    }
}
