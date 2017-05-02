package com.zw.permission.dao;

import com.zw.permission.entity.User;

/**
 * Created by Administrator on 2017/5/2.
 */
public interface UserDao {
    User findById(Integer id);
}
