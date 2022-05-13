package com.mapper;

import com.pojo.Cart;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface CartMapper {
    @Select("select * from cart where username=#{username}")
    public List<Cart> showUserCart(String username);

    @Update("update cart set quantity=#{quantity} where username=#{username} and gid=#{gid}")
    public Integer updateUserCart(String username,Integer quantity,Integer gid);

    @Insert("insert into cart(gid,username,gname,price,quantity,pic,description,create_time) value(#{gid},#{username},#{gname},#{price},#{quantity},#{pic},#{description},#{createTime})")
    public Integer insertCart(Cart cart);
    @Select("select * from cart where username=#{username} and gid=#{gid}")
    public Cart selectOneCart(String username,Integer gid);
    @Delete("delete from cart where username=#{username} and gid=#{gid}")
    public Integer deteleCart(String username,Long gid);
    @Select("select t. *, gname,pic,price from trolley t,goods g where t.gid = g.gid and t.uid=#{uid} and t.orders_number=''")
    public List<HashMap<String,Object>> getCarts(Integer uid);
}
