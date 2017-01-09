package com.liu.takeout.controller;

import com.liu.takeout.entity.Rider;
import com.liu.takeout.entity.RiderStatus;
import com.liu.takeout.service.RiderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by anybody on 2016/12/14.
 */
@Controller
public class RiderController {
    @Resource
    private RiderService riderService;

    @RequestMapping("riderList.action")
    public ModelAndView getRiderMap(@RequestParam(value = "search",required = false)String search){
        Map<Rider,RiderStatus> riderMap = riderService.getRider(search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("riderMap",riderMap);
        modelAndView.setViewName("riders");
        return modelAndView;
    }

    @RequestMapping(value = "changeRiderStatus.action",method = RequestMethod.POST)
    public ModelAndView changeRiderStatus(Rider rider){
        riderService.updateRiderStatus(rider);
        return new ModelAndView("redirect:/riderList.action");
    }
}
