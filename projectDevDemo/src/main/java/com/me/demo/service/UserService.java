package com.me.demo.service;

import com.me.demo.entity.User;

/**
 * @author codeY
 * @version 1.0
 * @date 2021/2/9 17:04
 */
public interface UserService {
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 要查找的用户对象
     */
    User findUserByName(String username);

    /**
     * 根据id查找用户
     * @param id  用户的id
     * @return 用户对象
     */
    User findUserById(Integer id);

    /**
     * 根据id删除用户
     * @param id 用户的id
     */
    void deleteUserById(Integer id);

    /**
     * 增加用户
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 更新用户对象
     * @param user 用户对象
     */
    void updateUser(User user);
}
