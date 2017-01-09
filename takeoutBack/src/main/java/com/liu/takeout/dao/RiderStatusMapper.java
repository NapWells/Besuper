package com.liu.takeout.dao;

import com.liu.takeout.entity.RiderStatus;

public interface RiderStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RiderStatus record);

    int insertSelective(RiderStatus record);

    RiderStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RiderStatus record);

    int updateByPrimaryKey(RiderStatus record);
}