package com.liu.takeout.service.impl;

import com.liu.takeout.dao.StaffAuthorityMapper;
import com.liu.takeout.dao.StaffMapper;
import com.liu.takeout.entity.Staff;
import com.liu.takeout.entity.StaffAuthority;
import com.liu.takeout.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private StaffMapper staffMapper;

    @Resource
    private StaffAuthorityMapper staffAuthorityMapper;

    @Override
    public Map<Staff,StaffAuthority> queryStaffList() {
        Map<Staff,StaffAuthority> queryStaffList = new LinkedHashMap<>();
        for (Staff staff : staffMapper.selectAllStaff()){
            queryStaffList.put(staff,staffAuthorityMapper.selectByPrimaryKey(staff.getStaffAuthorityId()));
        }
        return queryStaffList;
    }

    @Override
    public int updateStaff(Staff staff) {
        return staffMapper.updateByPrimaryKey(staff);
    }

    @Override
    public int deleteStaff(int staffId) {
        return staffMapper.deleteByPrimaryKey(staffId);
    }

    @Override
    public int addStaff(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public int getStaffPermission(String permission) {
        return staffAuthorityMapper.selectIdByName(permission).getId();
    }

    public Staff selectOneStaff(int id){
        return staffMapper.selectByPrimaryKey(id);
    }
}
