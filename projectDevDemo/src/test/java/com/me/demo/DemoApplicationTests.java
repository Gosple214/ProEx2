package com.me.demo;

import com.me.demo.entity.User;
import com.me.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
    }
    @Test
    void testAddUser(){
        User user = new User();
        user.setName("user1");
        user.setJob("job1");
        userService.addUser(user);
    }
    @Test
    void testFindUser(){
        System.out.println(userService.findUserById(1));
        System.out.println(userService.findUserByName("user1"));

    }
    @Test
    void updateUser(){
        User user = new User();
        user.setId(1);
        user.setName("user2");
        user.setJob("job1");
        userService.updateUser(user);
    }
    @Test
    void testDelete(){
        userService.deleteUserById(1);
    }
}
