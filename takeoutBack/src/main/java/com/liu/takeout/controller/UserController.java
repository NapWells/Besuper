package com.liu.takeout.controller;

import com.liu.takeout.entity.User;
import com.liu.takeout.service.UserService;
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
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("userList.action")
    public ModelAndView userList(@RequestParam(value = "search",required = false)String search){
        List<User> userList = userService.getUserList(search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping("deleteUser.action")
    public ModelAndView deleteUser(@RequestParam("id") int id){
        userService.deleteOneUser(id);
        return new ModelAndView("redirect:/userList.action");
    }



}
