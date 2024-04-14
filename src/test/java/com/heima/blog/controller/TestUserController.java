/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.controller;

import com.heima.blog.entity.User;
import com.heima.blog.mapper.UserMapper;
import com.heima.blog.sevice.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author wang shu long
 * @since 2024/4/14
 */
@SpringBootTest
public class TestUserController {
    private UserServiceImpl userServiceImplTest;
    @BeforeEach
    void setUp() {
        userServiceImplTest = new UserServiceImpl();
        userServiceImplTest.userMapper = mock(UserMapper.class);
    }

    @Test
    void testGetByParam(){
        // 构造入参
        String name = "wangshulong";

        // 构造数据库返回值
        final User user = new User();
        user.setId(1);
        user.setEmail("1659256933@qq.com");
        user.setSex("M");
        user.setUsername("wangshulong");
        user.setHobby("basketball");
        when(userServiceImplTest.userMapper.findByUserName(name)).thenReturn(user);

        User user1 = userServiceImplTest.findByUserName(name);
        Assertions.assertEquals(user1.getUsername(), name);
    }

    @Test
    void testConfig(){
        Assertions.assertEquals("1", userServiceImplTest.emailProperties.getCode());
    }
    @Test
    void testRegister() {
        System.out.println("hello world");
    }

    @Test
    void testRegister2() {
        System.out.println("hello world2");
    }
}
