package com.service;

import com.pojo.Trolley;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface TrolleyService {
    public List<HashMap<String,Object>> getCarts(Integer uid);
    public int updateGoodsNumber(Trolley trolley);
//    public int deleteGoods(Integer tid);
    public int insertTrolley(Trolley trolley,String yemian);
    public int allDetele(int [] tids);
    public int gouwuchecount(Integer uid);
    public Integer updateOrderNumber(String ordersNumber, List<Integer> ids);
}
