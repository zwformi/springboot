package com.zw.mapper;
import com.zw.entity.User;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */

@Mapper
public interface UserMapper {

        int save(User user);

        User selectById(Integer id);

        int updateById(User user);

        int deleteById(Integer id);

        List<User> queryAll();

}

