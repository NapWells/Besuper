package com.liu.takeout.service;


import com.liu.takeout.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList(String record);

    int deleteOneUser(int id);
}
