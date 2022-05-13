package com.service;

import com.pojo.Address;
import com.pojo.Orders;

import java.util.List;

public interface OrderService {
    public List<Address> showOrderByid(Integer uid);
    public int addOrder(Orders orders,List<Integer> ids);
}
