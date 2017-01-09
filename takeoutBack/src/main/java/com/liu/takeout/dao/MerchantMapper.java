package com.liu.takeout.dao;

import com.liu.takeout.entity.Merchant;

import java.util.List;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    List<Merchant> selectMerchantList(Merchant record);

    int updateMerchantStatus(Merchant record);
}