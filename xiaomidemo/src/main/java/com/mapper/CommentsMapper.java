package com.mapper;

import com.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsMapper {
    @Select("select * from comments where gid=#{gid}")
    public List<Comments> getCommentsByGid(Integer gid);
}
