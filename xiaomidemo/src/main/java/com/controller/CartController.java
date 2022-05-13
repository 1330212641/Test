package com.controller;

import com.pojo.Cart;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@CrossOrigin
@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping("/showUserCart")
    public HashMap<String,Object> showUserCart(String username){
        List<Cart> carts = this.cartService.showUserCart(username);
        HashMap<String,Object> cartMap=new HashMap<>();
        if(carts!=null){
            cartMap.put("code", 200);
            cartMap.put("msg", "显示成功");
            cartMap.put("total", carts.size());
            cartMap.put("data", carts);
            return cartMap;
        }
        cartMap.put("code", 500);
        cartMap.put("msg", "显示失败");
        return cartMap;
    }

//    @GetMapping("/updateUserCart")
//    public HashMap<String,Object> updateUserCart(String username,Integer quantity,Integer gid){
//        Integer integer = this.cartService.updateUserCart(username, quantity, gid);
//        HashMap<String,Object> cartMap=new HashMap<>();
//        if(integer>0){
//            cartMap.put("code", 200);
//            cartMap.put("msg", "修改成功");
//            cartMap.put("total", integer);
//            cartMap.put("data", integer);
//            return cartMap;
//        }
//        cartMap.put("code", 500);
//        cartMap.put("msg", "修改失败");
//        return cartMap;
//    }
//
//    @PostMapping("/insertCart")
//    public HashMap<String,Object> insertCart(Cart cart){
//        long gid = cart.getGid();
//        Long aLong = new Long(gid);
//        Integer igid = aLong.intValue();
//        Cart cart1 = this.cartService.selectOneCart(cart.getUsername(), igid);
//        HashMap<String,Object> cartMap=new HashMap<>();
//        if(cart1==null){
//            Date date = new Date();
//            cart.setCreateTime(new java.sql.Timestamp(date.getTime()));
//            Integer integer = this.cartService.insertCart(cart);
//
//            if(integer>0){
//                cartMap.put("code", 200);
//                cartMap.put("msg", "添加成功");
//                cartMap.put("total", integer);
//                cartMap.put("data", integer);
//                return cartMap;
//            }
//            cartMap.put("code", 500);
//            cartMap.put("msg", "添加失败");
//            return cartMap;
//
//
//        }else {
//            Long aLong1 = new Long(cart1.getQuantity() + 1);
//            Integer iQuantity = aLong1.intValue();
//            Integer integer = this.cartService.updateUserCart(cart.getUsername(), iQuantity, igid);
//            cartMap.put("code", 200);
//            cartMap.put("msg", "修改数量成功");
//            cartMap.put("total", integer);
//            cartMap.put("data", integer);
//            return cartMap;
//
//
//        }
//
//
//
//    }
//
//    @GetMapping("/deleteUserCart")
//    public HashMap<String,Object> deleteUserCart(String username,Long gid){
//        Integer integer = this.cartService.deteleCart(username, gid);
//        HashMap<String,Object> cartMap=new HashMap<>();
//        if(integer>0){
//            cartMap.put("code", 200);
//            cartMap.put("msg", "删除成功");
//            cartMap.put("total", integer);
//            cartMap.put("data", integer);
//            return cartMap;
//        }
//        cartMap.put("code", 500);
//        cartMap.put("msg", "删除失败");
//        return cartMap;
//    }
//    @GetMapping("/showCart")
//    public HashMap<String,Object> getCart(Integer uid){
//        List<HashMap<String,Object>> list = this.cartService.getCarts(uid);
//        HashMap<String,Object> hashMap=new HashMap<>();
//        if(list!=null){
//            hashMap.put("code", 200);
//            hashMap.put("msg", "显示成功");
//            hashMap.put("data", list);
//            return  hashMap;
//        }
//        hashMap.put("code", 500);
//        hashMap.put("msg", "显示失败");
//        return  hashMap;
//    }
}
