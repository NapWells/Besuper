package test.com.liu.takeout.service.impl;

import com.liu.takeout.entity.Manager;
import com.liu.takeout.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerServiceImplTest {

    @Autowired
    private ManagerService managerService;
    @Test

    public void testAddManager() throws Exception {
        Manager manager = new Manager();
        manager.setId(1004);
        manager.setNickname("caa");
        manager.setPassword("111");
        System.out.println(managerService.addManager(manager).getNickname());
    }


    @Test
    public void testLogin() throws Exception {
        System.out.println(managerService.login(1000,"00000").getNickname());
    }


} 
