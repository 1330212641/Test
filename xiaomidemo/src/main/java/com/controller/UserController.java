package com.controller;

import com.mapper.UserMapper;
import com.pojo.Goods;
import com.pojo.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import com.util.RndImage;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/login")
    public HashMap<String,Object> login(User user,String code,HttpServletRequest request){
        HttpSession session = request.getSession(true);
        String sessioncode = (String)session.getAttribute("checknum");
        HashMap<String,Object> map = new HashMap<>();
        User u = userService.login(user);
        if (code.equals(sessioncode)) {
            if (u != null) {
                user.setPassword("");
                map.put("code", 200);
                map.put("msg", "成功");
                map.put("user", u);
            }else{
                map.put("code", 401);
                map.put("msg", "用户名或密码错误");
            }
        }
//        else {
//            map.put("code",402);
//            map.put("msg","验证码错误！");
//        }
        return map;
    }
    @GetMapping(value = "/getCheckCode")
    public void checkNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应类型，告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存次内容
        response.setHeader("pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expire",0);
        String num = RndImage.random();
        HttpSession session=request.getSession(true);
        session.setAttribute("checknum",num);
        try {
            RndImage.imageOut(num,response.getOutputStream(),150,60);//输出图片方法
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/showUser")
    public HashMap<String, Object> showUser() {
        List<User> list = userService.showUser();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("data", list);
        return map;

    }
    @PostMapping("/updateState")
    public HashMap<String,Object> updateGoodsNumber(Integer uid,Integer manager){//传过来的是json对象
        int i = this.userService.UpdateManager(uid,manager);
        HashMap<String ,Object> hashMap=new HashMap<>();
        if(i>0){
            hashMap.put("code",200);
            hashMap.put("msg","成功");
            return hashMap;
        }else {
            hashMap.put("code", 401);
            hashMap.put("msg", "获取失败");
            return hashMap;
        }
    }
    @PostMapping("/deleteUser")
    public HashMap<String ,Object> deleteUser(@RequestBody List<Integer> uids){
        System.out.println(uids.size());
        int i = this.userService.deleteuser(uids);
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
    @GetMapping("/deleteuser")
    public HashMap<String ,Object> deleteuser(Integer uid){
        int i = this.userService.deleteuser1(uid);
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
    @PostMapping("/addUser")
    public HashMap<String ,Object> addUser(User user,HttpServletRequest request){
        Date date=new Date();
        Timestamp d=new Timestamp(date.getTime());
        user.setCreateTime(d);
        HashMap<String ,Object> hashMap=new HashMap<>();
        HttpSession session= request.getSession(true);
        int i = this.userService.adduser(user);
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
}
