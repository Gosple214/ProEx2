package com.me.demo.mapper;

import com.me.demo.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @author codeY
 * @version 1.0
 * @date 2021/2/9 17:04
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 要查找的用户对象
     */
    @Select("select * from proEx2.user where name=#{username}")
    User findUserByName(@Param("username") String username);

    /**
     * 根据id查找用户
     * @param id  用户的id
     * @return 用户对象
     */
    @Select(("select * from proEx2.user where id = #{id}"))
    User findUserById(@Param("id") Integer id);

    /**
     * 根据id删除用户
     * @param id 用户的id
     */
    @Delete("delete from proEx2.user where id = #{id}")
    void deleteUserById(@Param("id") Integer id);

    /**
     * 增加用户
     * @param user 用户对象
     */
    @Insert("insert into proEx2.user(name,job) values(#{name},#{job})")
    void addUser(User user);

    /**
     * 更新用户对象
     * @param user 用户对象
     */
    @Update("update proEx2.user set name=#{name},job=#{job} where id =#{id}")
    void updateUser(User user);
}
