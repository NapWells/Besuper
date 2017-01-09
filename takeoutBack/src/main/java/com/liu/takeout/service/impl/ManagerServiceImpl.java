package com.liu.takeout.service.impl;

import com.liu.takeout.dao.ManagerMapper;
import com.liu.takeout.entity.Manager;
import com.liu.takeout.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service
public class ManagerServiceImpl implements ManagerService{

    @Resource
    private ManagerMapper managerMapper;

    public Manager addManager(Manager manager) {
        int result = managerMapper.insert(manager);
        if(result == 1)
            return managerMapper.selectByPrimaryKey(manager.getId());
        return null;
    }

    public Manager login(int id, String password) {
        Manager manager = new Manager();
        manager.setId(id);
        manager.setPassword(password);
        return managerMapper.selectOneManager(manager);
    }

    public Manager updateManager(Manager manager) {
        int rowAffect = managerMapper.updateByPrimaryKey(manager);
        if(rowAffect==1)
            return managerMapper.selectByPrimaryKey(manager.getId());
        return null;
    }


}
