/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.controller;

import com.heima.blog.entity.User;
import com.heima.blog.handlers.YearTableNameHandler;
import com.heima.blog.pojo.Result;
import com.heima.blog.pojo.SearchBean;
import com.heima.blog.sevice.IUserService;
import com.heima.blog.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        // 查询用户
        User user = iUserService.findByUserName(username);
        if (Objects.isNull(user)) {
            // iUserService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已占用");
        }
    }

    @PostMapping("/select")
    public Result<List<User>> selectAll(@RequestBody SearchBean<User> searchBean) {
        List<User> users = iUserService.selectByCondition(searchBean);
        return Result.success(users);
    }

    /**
     * 获取今年的所有成员
     */
    @GetMapping("/current_year")
    public Result<List<User>> getCurrentUser() {
        return Result.success(iUserService.list());
    }

    @GetMapping("/2024_year")
    public Result<List<User>> get2024User() {
        YearTableNameHandler.setYearData("2024");
        return Result.success(iUserService.list());
    }
}
