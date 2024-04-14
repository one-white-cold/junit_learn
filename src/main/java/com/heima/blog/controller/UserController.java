/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.controller;

import com.heima.blog.entity.User;
import com.heima.blog.pojo.Result;
import com.heima.blog.sevice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author wang shu long
 * @since 2024/4/14
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @PostMapping("/register")
    public Result register(String username, String password) {
        // 查询用户
        User user = iUserService.findByUserName(username);
        if(Objects.isNull(user)){
            //iUserService.register(username, password);
            return Result.success();
        }else {
            return Result.error("用户名已占用");
        }
    }
}
