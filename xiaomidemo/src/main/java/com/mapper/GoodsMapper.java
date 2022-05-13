package com.mapper;

import com.github.pagehelper.Page;
import com.pojo.Goods;
import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where state=#{state}")
    public List<Goods> showGoodsByState(Integer state);
    @Select("select * from goods where zlanmu=#{zlanmu}")
    public List<Goods> showGoodsByzlanmu(String zlanmu);
    @Select("select * from goods where gid=#{gid}")
    @Results({
                @Result(id=true,property = "gid",column = "gid"),
            @Result(property = "commentsList",column = "gid" ,javaType = List.class,
            many=@Many(select = "com.mapper.CommentsMapper.getCommentsByGid"))
    })
    public Goods getGoodsBygid(Integer gid);
    @Select("select * from goods")
    public List<Goods> showAllgoods();
    @Delete("delete from goods where gid=#{gid}")
    public int deleteGoods(Integer gid);
    @Delete({
            "<script>"+
                    "delete from goods where gid in "+
                    "<foreach collection=\"gids\" item=\"gid\" separator=\",\" open=\"(\" close=\")\"> #{gid}"+
                    "</foreach>"+
                    "</script>"
    })
    public int deleteGood(List<Integer> gids);
    @Insert("insert into goods(cid,gname,color,size,price,description,pic,state,version,product_date) values(#{cid},#{gname},#{color},#{size},#{price},#{description},#{pic},#{version},#{state},#{productDate})")
    public int addGoods(Goods goods);
    @Update("update goods set state=#{state} where gid=#{gid}")
    public int updateState(Integer gid,Integer state);
    @Update("update goods set zlanmu=#{zlanmu},cid=#{cid},gname=#{gname},color=#{color},price=#{price},description=#{description},pic=#{pic},state=#{state},version=#{version} where gid=#{gid}")
    public int updateGoods(Goods goods);
}
