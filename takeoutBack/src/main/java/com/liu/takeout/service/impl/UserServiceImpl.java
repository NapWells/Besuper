package com.liu.takeout.service.impl;

import com.liu.takeout.dao.UserMapper;
import com.liu.takeout.entity.User;
import com.liu.takeout.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anybody on 2016/12/14.
 */
@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getUserList(String search) {
        User user = new User();
        if(search!=null)
            user.setUsername(search);
        return userMapper.getUserList(user);
    }

    @Override
    public int deleteOneUser(int record) {
        return userMapper.deleteOneUser(record);
    }
}
