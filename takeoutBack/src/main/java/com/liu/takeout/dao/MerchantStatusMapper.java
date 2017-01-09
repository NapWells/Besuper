package com.liu.takeout.dao;

import com.liu.takeout.entity.MerchantStatus;

public interface MerchantStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantStatus record);

    int insertSelective(MerchantStatus record);

    MerchantStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantStatus record);

    int updateByPrimaryKey(MerchantStatus record);
}