package com.zw.permission.service.impl;

import com.zw.permission.dao.UserDao;
import com.zw.permission.entity.User;
import com.zw.permission.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public User findById(int id) {
          return this.userDao.findById(id);
       // return this.userDao.selectByPrimaryKey(id);
    }
}
