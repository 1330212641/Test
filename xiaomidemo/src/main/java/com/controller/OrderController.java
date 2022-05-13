package com.controller;

import com.pojo.Address;
import com.pojo.Goods;
import com.pojo.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/showAddress")
    public HashMap<String, Object> showOrderByid(Integer uid) {
        HashMap<String, Object> map = new HashMap<>();
        List<Address> list = orderService.showOrderByid(uid);
        if (list!=null){
            map.put("code", 200);
            map.put("msg", "成功获取");
            map.put("rows", list);
            return map;
        }else {
            map.put("code",401);
            map.put("msg","失败");
        }
        return map;
    }
    @PostMapping("/addorder")
    public HashMap<String,Object> addOrders(@RequestBody HashMap<String,Object> m){
        System.out.println(m);
        HashMap<String,Object> map=new HashMap<>();
        Integer id=(Integer) m.get("id");
        String name = (String) m.get("name");
        List<HashMap<String ,Object>> list=(List<HashMap<String, Object>>)m.get("list") ;
        System.out.println(list);
        Orders orders=new Orders();
        orders.setOrdersNumber(UUID.randomUUID().toString());
        orders.setId(id);
        float totalprice=0;
        int counttotal=0;
        List<Integer> ids=new ArrayList<>();
        for (HashMap<String,Object> hashMap:list){
            orders.setUid(Long.parseLong(hashMap.get("uid")+""));
            totalprice+=(Float.parseFloat(hashMap.get("price")+""))*Integer.parseInt(hashMap.get("number")+"");
            counttotal+=Integer.parseInt(hashMap.get("number")+"");
            ids.add((Integer) hashMap.get("tid"));
            System.out.println(hashMap);
        }
        orders.setCountNumber(counttotal);
        orders.setSumPrice(totalprice);
        orders.setState(0);
        orders.setCreateTime(new Timestamp(new Date().getTime()));
        int i=this.orderService.addOrder(orders,ids);
        map.put("code",200);
        map.put("msg","成功");
        return map;
    }
    
}
