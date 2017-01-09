package com.liu.takeout.dao;

import com.liu.takeout.entity.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager manager);

    int insertSelective(Manager manager);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager manager);

    int updateByPrimaryKey(Manager manager);


    //自定义
    //账号密码登陆
    Manager selectOneManager(Manager manager);
}