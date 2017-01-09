package com.liu.takeout.controller;

import com.liu.takeout.entity.Staff;
import com.liu.takeout.entity.StaffAuthority;
import com.liu.takeout.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by anybody on 2016/12/13.
 */
@Controller
public class EmployeeContreller {
    @Resource
    private EmployeeService employeeService;



    @RequestMapping("staffList.action")
    public ModelAndView staffList(){
        Map<Staff,StaffAuthority> staffList = employeeService.queryStaffList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("staffList",staffList);
        modelAndView.setViewName("employee");
        return modelAndView;
    }

    @RequestMapping("updateStaff.action")
    public ModelAndView updateStaff(Staff staff, @RequestParam("permission")String permission){
        staff.setStaffAuthorityId(employeeService.getStaffPermission(permission));
        employeeService.updateStaff(staff);
        return new ModelAndView("redirect:/staffList.action");
    }

    @RequestMapping("deleteStaff.action")
    public ModelAndView deleteStaff(int id){
        employeeService.deleteStaff(id);
        return new ModelAndView("redirect:/staffList.action");
    }

    @RequestMapping("addStaff.action")
    public ModelAndView addStaff(Staff staff,@RequestParam("permission")String permission){
        staff.setStaffAuthorityId(employeeService.getStaffPermission(permission));
        employeeService.addStaff(staff);
        return new ModelAndView("redirect:/staffList.action");
    }
}
