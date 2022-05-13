package com.mapper;

import com.pojo.Cart;
import com.pojo.Trolley;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface TrolleyMapper {
    //根据用户名显示购物车数据
    @Select("SELECT t.*,gname,pic,price from goods g,trolley t WHERE t.gid=g.gid and t.uid=#{uid} and t.orders_number=''")
    public List<HashMap<String,Object>> getCarts(Integer uid);
    //修改购物车某件商品的数量
    @Update("update trolley set number=#{number} where uid=#{uid} and gid=#{gid} and orders_number='' ")
    public int updateGoodsNumber(Trolley trolley);
    @Delete("delete from trolley where tid=#{tid}")
    public int deleteGoods(Integer tid);
    @Select("select count(*) from trolley where uid=#{uid}")
    public int gouwuchecount(Integer uid);
    @Insert("insert into trolley(uid,gid,number) value(#{uid},#{gid},#{number})")
    public int insertTrolley(Trolley trolley);
    @Select("select * from trolley where uid=#{uid} and gid=#{gid}")
    public Trolley selectOneTrolley(Trolley trolley);
    @Update({"<script>"+
            "update trolley set orders_number=#{orderNumber} where tid in "+
            "<foreach collection=\"ids\" item=\"id\" separator=\",\" open=\"(\" close=\")\">#{id}" +
            "</foreach>"+
            "</script>"})
    public int updateOrderNumber(String orderNumber,List<Integer> ids);
}
