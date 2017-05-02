package com.zw.controller;

import com.zw.dao.UserDao;
import com.zw.entity.User;
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
    private UserDao UserDao;

    @RequestMapping("/test")
    String test1(){
        return "hello,I'm test1()";
    }
    @RequestMapping("/findUser")
    User findUser(@RequestParam String id){
        return UserDao.getUser(Integer.valueOf(id));
    }

    @RequestMapping("/now")
    public String getTime() {
        return "现在时间：" + (new Date()).toLocaleString();
    }
}

