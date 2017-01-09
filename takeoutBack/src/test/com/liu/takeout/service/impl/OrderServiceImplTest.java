package com.liu.takeout.service.impl;

import com.liu.takeout.entity.OrderManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OrderServiceImplTest { 

    @Autowired
    private OrderServiceImpl orderService;
@Test
public void testGetOrders() throws Exception { 
    for (OrderManager orderManager : orderService.getOrders(null)){
        System.out.println(orderManager);
    }
} 


} 
