package com.service;

import com.pojo.Cart;
import java.util.HashMap;
import java.util.List;

public interface CartService {
    public List<Cart> showUserCart(String username);
    public Integer updateUserCart(String username,Integer quantity,Integer gid);

    public Integer insertCart(Cart cart);

    public Cart selectOneCart(String username,Integer gid);

    public Integer deteleCart(String username,Long gid);
    public List<HashMap<String,Object>> getCarts(Integer uid);


}
