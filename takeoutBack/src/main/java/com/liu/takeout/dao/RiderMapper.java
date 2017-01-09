package com.liu.takeout.dao;

import com.liu.takeout.entity.Rider;

import java.util.List;

public interface RiderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rider record);

    int insertSelective(Rider record);

    Rider selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rider record);

    int updateByPrimaryKey(Rider record);

    List<Rider> getRiderList(Rider rider);

    int updateRiderStatus(Rider rider);
}