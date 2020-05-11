package com.iss.dao;

import com.iss.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    //1.查询所有用户
    @Select("select * from users")
    public List<User>getAllUser();

    //1.2查询所有用户数量
    @Select("select count(*) from users")
    public int getAllUserNumber();

    //1.3通过用户id判断此用户是否已经存在（增加时使用）
    @Select("select count(*) from users where userid=#{userid}")
    public int findUserid(@Param("userid") String userid);

    //2.1前端通过用户id和类型查询
    @Select("select * from users where type like CONCAT('%',#{type},'%') and userid like CONCAT('%',#{userid},'%') LIMIT #{pageIndex},#{pageSize}")
    public List<User> getAllUser1(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("type") String type,@Param("userid")String userid);


    //2.2前端通过用户id和类型查询用户数量
    @Select("select count(*) from course users where type like CONCAT('%',#{type},'%') and userid like CONCAT('%',#{userid},'%')")
    public int getAllUserNumber1(@Param("type") String type,@Param("userid") String userid);

    //3.添加用户
    @Insert("INSERT INTO users VALUE (#{userid},#{name},#{loginid},#{password},#{type})")
    public int addUser(User user);


    //4.删除用户
    @Delete("delete from users where userid=#{userid}")
    public int deleteUser(@Param("userid")String userid);

    //5.修改用户登录信息
    @Update("update users set name=#{name},loginid=#{loginid},password=#{password},type=#{type} where userid=#{userid}")
    public int updateUser(@Param("name")String name,@Param("loginid")String loginid,@Param("password")String password,@Param("type")String type,@Param("userid")String userid);

}
