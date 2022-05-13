package com.mapper;

import com.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category where state=#{state}")
    public List<Category> showcategory(Integer state);
}
