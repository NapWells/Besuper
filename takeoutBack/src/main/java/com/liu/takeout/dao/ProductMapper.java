package com.liu.takeout.dao;

import com.liu.takeout.entity.Product;
import com.liu.takeout.entity.ProductKey;

public interface ProductMapper {
    int deleteByPrimaryKey(ProductKey key);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(ProductKey key);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}