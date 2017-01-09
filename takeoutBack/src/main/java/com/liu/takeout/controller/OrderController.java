package com.liu.takeout.controller;

import com.liu.takeout.entity.OrderManager;
import com.liu.takeout.service.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by anybody on 2016/12/14.
 */
@Controller
public class OrderController {
    @Resource
    private OrderServiceImpl orderService;

    @RequestMapping("getOrderList.action")
    public ModelAndView getOrderList(OrderManager orderManager){
        List<OrderManager> orderManagerList = orderService.getOrders(orderManager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderManagerList",orderManagerList);
        modelAndView.setViewName("orders");
        return modelAndView;
    }

    @RequestMapping("cancelOrder.action")
    public ModelAndView cancelOrder(@RequestParam("id")long id){
        orderService.cancelOrder(id);
        return new ModelAndView("redirect:/getOrderList.action");
    }


}
