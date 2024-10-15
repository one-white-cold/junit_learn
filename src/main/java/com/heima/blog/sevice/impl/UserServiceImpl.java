/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.sevice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.blog.configproperties.EmailProperties;
import com.heima.blog.entity.User;
import com.heima.blog.mapper.UserMapper;
import com.heima.blog.pojo.SearchBean;
import com.heima.blog.sevice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author wang shu long
 * @since 2024/4/14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Value("${email.code}")
    private String code;
    @Autowired
    public UserMapper userMapper;

    @Autowired
    public EmailProperties emailProperties;

    @Override
    public User findByUserName(String username) {
        System.out.println(emailProperties.getCode());
        System.out.println(emailProperties.getUser());
        System.out.println(code);
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        // todo 加密

        // 添加
        userMapper.add(username, password);
    }

    public List<User> selectByCondition(SearchBean<User> searchBean) {
        Page<User> page = new Page<>(searchBean.getPageNum(), searchBean.getPageSize());

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (Objects.nonNull(searchBean.getData()) && Objects.nonNull(searchBean.getData().getUsername())) {
            queryWrapper.like("username", searchBean.getData().getUsername());
        }
        userMapper.selectPage(page, queryWrapper);
        return page.getRecords();
    }
}
