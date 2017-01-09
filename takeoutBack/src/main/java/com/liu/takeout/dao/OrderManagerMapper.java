package com.liu.takeout.dao;

import com.liu.takeout.entity.OrderManager;

import java.util.List;

/**
 * Created by anybody on 2016/12/14.
 */
public interface OrderManagerMapper {
    List<OrderManager> selectOrderList(OrderManager orderManager);
}
