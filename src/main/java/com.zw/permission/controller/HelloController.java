package com.zw.permission.controller;

import com.zw.permission.entity.User;
import com.zw.permission.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * Created by Administrator on 2017/5/2.
 */
@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
public class HelloController {
    @Resource
    private UserService userService;
    @RequestMapping("/test")
    public String test1(){
        return "hello,I'm test1()";
    }
    @RequestMapping("/findUser")
    public String findUser(@RequestParam String id){
        return userService.findById(Integer.valueOf(id)).toString();
    }

    @RequestMapping("/now")
    public String getTime() {
        return "现在时间：" + (new Date()).toLocaleString();
    }
}

