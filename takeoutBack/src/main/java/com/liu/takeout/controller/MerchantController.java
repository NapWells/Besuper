package com.liu.takeout.controller;

import com.liu.takeout.entity.Merchant;
import com.liu.takeout.entity.MerchantStatus;
import com.liu.takeout.service.impl.MerchantServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class MerchantController {

    @Resource
    private MerchantServiceImpl merchantService;

    @RequestMapping("merchantList.action")
    public ModelAndView getMerchantMap(@RequestParam(value = "search",required = false)String search){
        Map<Merchant,MerchantStatus> merchantMap = merchantService.getMerchant(search);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("merchantMap",merchantMap);
        modelAndView.setViewName("shops");
        return modelAndView;
    }

    @RequestMapping(value = "passOrStop.action",method = RequestMethod.POST)
    public ModelAndView passOrStop(Merchant merchant){
        merchantService.updateMerchantStatus(merchant);
        return new ModelAndView("redirect:/merchantList.action");
    }

}
