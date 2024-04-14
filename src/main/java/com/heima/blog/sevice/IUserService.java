/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.sevice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.blog.entity.User;

public interface IUserService extends IService<User> {
    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册用户
    void register(String username, String password);
}
