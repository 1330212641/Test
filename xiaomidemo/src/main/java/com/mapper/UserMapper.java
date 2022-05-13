package com.mapper;

import com.pojo.Role;
import com.pojo.User;
import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(User user);
    @Select("select * from user")
    public List<User> showUser();
    @Update("update user set manager=#{manager} where uid=#{uid}")
    public int UpdateManager(Integer uid, Integer manager);
    @Delete({
            "<script>"+
                    "delete from user where uid in "+
                    "<foreach collection=\"uids\" item=\"uid\" separator=\",\" open=\"(\" close=\")\"> #{uid}"+
                    "</foreach>"+
                    "</script>"
    })
    public int deleteuser(List<Integer> uids);
    @Delete("delete from user where uid=#{uid} ")
    public int deleteuser1(Integer uid);
    @Insert("insert into user(name,sex,phone_number,area,manager,username,password,photo,create_time) values(#{name},#{sex},#{phoneNumber},#{area},#{manager},#{username},#{password},#{photo},#{createTime})")
    public int addUser(User user);



    //判断用户名是否存在
    @Select("select * from user where username=#{username}")
    public User loadUserByUsername(String username);

    //获取用户所具有的角色
    @Select("select * from role r,user_role ur where r.rid =ur.rid and ur.uid=#{uid}")
    public List<Role> getUserRolesByUid(long uid);
}
