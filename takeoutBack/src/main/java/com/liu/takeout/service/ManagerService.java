package com.liu.takeout.service;


import com.liu.takeout.entity.Manager;

public interface ManagerService {
    Manager addManager(Manager manager);

    Manager login(int id,String password);

    Manager updateManager(Manager manager);
}
