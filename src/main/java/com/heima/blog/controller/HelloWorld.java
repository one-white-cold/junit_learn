/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.heima.blog.controller;

import com.heima.blog.configproperties.EmailProperties;
import com.heima.blog.entity.User;
import com.heima.blog.sevice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang shu long
 * @since 2024/4/14
 **/
@RestController()
public class HelloWorld {
    @Autowired
    private EmailProperties emailProperties;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println(emailProperties.getUser());
        System.out.println(emailProperties.getCode());
        return "hello world!";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        return iUserService.getById(id);
        //return new User();
    }
}
