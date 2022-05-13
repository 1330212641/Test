package com.service;

import com.mapper.TrolleyMapper;
import com.pojo.Trolley;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TrolleyServiceImpl implements TrolleyService {
    @Resource
    TrolleyMapper trolleyMapper;

    @Override
    public List<HashMap<String, Object>> getCarts(Integer uid) {
        List<HashMap<String, Object>> carts = this.trolleyMapper.getCarts(uid);
        return carts;
    }

    @Override
    public int updateGoodsNumber(Trolley trolley) {
        int i = this.trolleyMapper.updateGoodsNumber(trolley);
        return i;
    }

//    @Override
//    public int deleteGoods(Integer tid) {
//        int i = this.trolleyMapper.deleteGoods(tid);
//        return i;
//    }

    @Override
    public int insertTrolley(Trolley trolley,String yemian) {
        Trolley trolley1 = this.trolleyMapper.selectOneTrolley(trolley);
        if(trolley1==null){
            int i = this.trolleyMapper.insertTrolley(trolley);
            return i;
        }else {
            if(yemian.equals("details")){
                trolley.setNumber(trolley.getNumber()+trolley1.getNumber());
                int i=this.trolleyMapper.updateGoodsNumber(trolley);
                return i;
            }else {
                int i = this.trolleyMapper.updateGoodsNumber(trolley);
                return i;
            }


        }
    }

    @Override
    public int allDetele(int[] tids) {
        int count=0;
        for (int tid: tids){
            int i = this.trolleyMapper.deleteGoods(tid);
            count+=i;
        }
        return count;
    }

    @Override
    public int gouwuchecount(Integer uid) {
        return trolleyMapper.gouwuchecount(uid);
    }
    @Override
    public Integer updateOrderNumber(String ordersNumber, List<Integer> ids) {
        return trolleyMapper.updateOrderNumber(ordersNumber,ids);
    }
}
