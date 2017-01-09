package com.liu.takeout.service.impl;

import com.liu.takeout.dao.OrderManagerMapper;
import com.liu.takeout.dao.OrderMapper;
import com.liu.takeout.entity.OrderManager;
import com.liu.takeout.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anybody on 2016/12/14.
 */
@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderManagerMapper orderManagerMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderManager> getOrders(OrderManager orderManager) {
        return orderManagerMapper.selectOrderList(orderManager);
    }

    @Override
    public int cancelOrder(long id) {
        return orderMapper.cancelOrderById(id);
    }
}
