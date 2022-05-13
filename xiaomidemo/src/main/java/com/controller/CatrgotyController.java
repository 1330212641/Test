package com.controller;

import com.pojo.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class CatrgotyController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/showcategory")
    public HashMap<String, Object> showcategoty(Integer state) {
        List<Category> list = categoryService.showcategory(state);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功获取");
        map.put("total", list.size());
        map.put("data", list);
        return map;
    }
    @GetMapping("/getCategorys")
    public HashMap<String,Object> getCategorys(HttpServletRequest request){
        List<String> list = new ArrayList<>();
        list.add("http//"+request.getServerName()+":"+request.getServerPort()+"images/scroll_01.jpg");
        list.add("http//"+request.getServerName()+":"+request.getServerPort()+"images/scroll_02.jpg");
        list.add("http//"+request.getServerName()+":"+request.getServerPort()+"images/scroll_03.jpg");
        list.add("http//"+request.getServerName()+":"+request.getServerPort()+"images/scroll_04.jpg");
        list.add("http//"+request.getServerName()+":"+request.getServerPort()+"images/scroll_05.jpg");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("code",200);
        hashMap.put("msg","成功");
        hashMap.put("total",list.size());
        hashMap.put("rows",list);
        return hashMap;
    }
}
