package com.controller;

import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AlipayController {
    @Autowired
    OrderService orderService;
//    @GetMapping("/alipay_back")
//    public String alipayback(@RequestParam Map<String,String> params, HttpServletRequest request){
//        String orderNo = params.get("out_trade_no");
//        String tradeNo = params.get("trade_no");
//        String tradeStatus = params.get("trade_status");
//        System.out.println(orderNo+"  "+tradeNo+"   "+tradeStatus);
//        Order order = orderService.getClass()
//    }
}
