package com.service;

import com.mapper.CartMapper;
import com.mapper.TrolleyMapper;
import com.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Resource
    CartMapper cartMapper;
    TrolleyMapper trolleyMapper;
    @Override
    public List<Cart> showUserCart(String username) {
        List<Cart> carts = this.cartMapper.showUserCart(username);
        return carts;
    }

    @Override
    public Integer updateUserCart(String username, Integer quantity, Integer gid) {
        Integer integer = this.cartMapper.updateUserCart(username, quantity, gid);
        return integer;
    }

    @Override
    public Integer insertCart(Cart cart) {
        Integer integer = this.cartMapper.insertCart(cart);
        return integer;
    }

    @Override
    public Cart selectOneCart(String username, Integer gid) {
        Cart cart = this.cartMapper.selectOneCart(username, gid);
        return cart;
    }

    @Override
    public Integer deteleCart(String username,Long gid) {
        Integer integer = this.cartMapper.deteleCart(username,gid);
        return integer;
    }

    @Override
    public List<HashMap<String, Object>> getCarts(Integer uid) {
        List<HashMap<String,Object>> carts = this.cartMapper.getCarts(uid);
        return carts;
    }


}
