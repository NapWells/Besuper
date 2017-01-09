package com.liu.takeout.service.impl;

import com.liu.takeout.entity.Staff;
import com.liu.takeout.entity.StaffAuthority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Test
    public void testQueryStaffList() throws Exception {
        Map<Staff, StaffAuthority> staffList = employeeService.queryStaffList();
        for (Map.Entry<Staff,StaffAuthority> entry : staffList.entrySet()){
            System.out.println(entry.getKey().getName()+"     "+entry.getValue().getName());
        }


    }

    @Test
    public void testUpdateStaff() throws Exception {
        Staff staff = new Staff();
        staff.setId(1);
        staff.setPhone("123456789");
        System.out.println(employeeService.updateStaff(staff));
    }

    @Test
    public void testDeleteStaff() throws Exception {
        System.out.println(employeeService.deleteStaff(5));
    }


    @Test
    public void testAddStaff() throws Exception {
        Staff staff = new Staff();
        staff.setPhone("123456789");
        staff.setName("撒啊发撒法发");
        System.out.println(employeeService.addStaff(staff));
    }

    @Test
    public void testSelectOne() throws Exception {
       System.out.println(employeeService.selectOneStaff(6));
    }


} 
