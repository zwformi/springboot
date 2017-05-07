package com.zw.permission.dao;

import com.zw.permission.entity.User;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/2.
 */
public interface UserDao {
    User findById(Integer id);

/*    @Select("SELECT * from `user_t`  where id = #{id}")
    @ResultType(User.class)*/
    User selectByPrimaryKey(Integer id);
}
