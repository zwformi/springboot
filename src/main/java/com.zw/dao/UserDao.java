package com.zw.dao;

import com.zw.entity.User;
import com.zw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/2.
 */
@Repository("UserDAO")
public class UserDao {
    @Autowired
    private UserMapper UserMapper;

    public User getUser(Integer id){
        return UserMapper.findUserById(id);
    }

}
