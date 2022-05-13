package com.service;

import com.pojo.Goods;
import com.util.PageResult;

import java.util.List;

public interface GoodsService {
    public List<Goods> getGoodsByState(Integer state);
    public List<Goods> getGoodsByzlanmu(String zlanmu);
    public Goods getGoodsBygid(Integer gid);
    public List<Goods> showAllgoods();
    public Integer deleteGoods(Integer gid);
    public Integer deleteGood(List<Integer> gid);
    public int addGoods(Goods goods);
    public int updateGoods(Goods goods);
    public int updateState(Integer gid,Integer state);
}
