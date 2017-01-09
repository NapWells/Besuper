package com.liu.takeout.dao;

import com.liu.takeout.entity.StaffAuthority;

public interface StaffAuthorityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffAuthority record);

    int insertSelective(StaffAuthority record);

    StaffAuthority selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffAuthority record);

    int updateByPrimaryKey(StaffAuthority record);

    StaffAuthority selectIdByName(String name);
}