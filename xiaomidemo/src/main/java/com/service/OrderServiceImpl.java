package com.service;

import com.mapper.OrderMapper;
import com.pojo.Address;
import com.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Override
    public List<Address> showOrderByid(Integer uid) {
        return orderMapper.showOrderByid(uid);
    }
    @Autowired
    TrolleyService trolleyService;
    @Transactional(propagation = Propagation.REQUIRED, timeout = 6000, rollbackFor = Exception.class)
    @Override
    public int addOrder(Orders orders, List<Integer> ids) {
        int flag = 0;
        int i = orderMapper.insertOrders(orders);
        if (i > 0) {
            int j =trolleyService.updateOrderNumber(orders.getOrdersNumber(), ids);
            System.out.println("这是一个程序" + j);
            if (j > 0) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        return flag;
    }
}
