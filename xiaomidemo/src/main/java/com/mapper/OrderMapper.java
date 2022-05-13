package com.mapper;

import com.pojo.Address;
import com.pojo.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from address where uid=#{uid}")
    public List<Address> showOrderByid(Integer uid);
    @Insert("insert into orders value(#{ordersNumber},#{uid},#{sumPrice},#{state},#{createTime},#{countNumber},#{id})")
    public int insertOrders(Orders orders);
}
