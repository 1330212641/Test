package com.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mapper.GoodsMapper;
import com.pojo.Goods;
import com.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsByState(Integer state) {
        System.out.println(state + "逻辑层");
        return goodsMapper.showGoodsByState(state);
    }
    @Override
    public List<Goods> getGoodsByzlanmu(String zlanmu) {
        return goodsMapper.showGoodsByzlanmu(zlanmu);
    }

    @Override
    public Goods getGoodsBygid(Integer gid) {
        return  goodsMapper.getGoodsBygid(gid);
    }

//    @Override
//    public PageResult<Goods> showAllgoods(int currentPage, int pageSize) {
//        PageHelper.startPage(currentPage, pageSize);
//        Page<Goods> pageList = (Page<Goods>) goodsMapper.showAllgoods();
//        PageResult<Goods> rg = new PageResult<Goods>(pageList.getTotal(),pageList.getResult(),currentPage,pageSize);
//        System.out.println(pageList.getResult());
//        return rg;
//    }

    @Override
    public Integer deleteGoods(Integer gid) {
        return goodsMapper.deleteGoods(gid);
    }

    @Override
    public Integer deleteGood(List<Integer> gid) {
        return goodsMapper.deleteGood(gid);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return  goodsMapper.updateGoods(goods);
    }

    @Override
    public int updateState(Integer gid, Integer state) {
        return  goodsMapper.updateState(gid, state);
    }

    @Override
    public List<Goods> showAllgoods() {
        return  goodsMapper.showAllgoods();
    }
}
