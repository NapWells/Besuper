package com.liu.takeout.service;

import com.liu.takeout.entity.Staff;
import com.liu.takeout.entity.StaffAuthority;

import java.util.Map;

/**
 * Created by anybody on 2016/12/13.
 */
public interface EmployeeService {

    Map<Staff,StaffAuthority> queryStaffList();

    int updateStaff(Staff staff);

    int deleteStaff(int staffId);

    int addStaff(Staff staff);

    int getStaffPermission(String permission);

}
