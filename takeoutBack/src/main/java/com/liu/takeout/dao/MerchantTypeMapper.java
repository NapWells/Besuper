package com.liu.takeout.dao;

import com.liu.takeout.entity.MerchantType;

public interface MerchantTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantType record);

    int insertSelective(MerchantType record);

    MerchantType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantType record);

    int updateByPrimaryKey(MerchantType record);
}