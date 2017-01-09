package com.liu.takeout.service;

import com.liu.takeout.entity.OrderManager;

import java.util.List;

/**
 * Created by anybody on 2016/12/14.
 */
public interface OrderService {
    List<OrderManager> getOrders(OrderManager orderManager);

    int cancelOrder(long id);
}
