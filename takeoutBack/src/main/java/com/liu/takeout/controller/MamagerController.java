package com.liu.takeout.controller;

import com.google.gson.Gson;
import com.liu.takeout.entity.Manager;
import com.liu.takeout.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MamagerController {
    @Resource
    private ManagerService managerService;

    @RequestMapping("/loginPage.action")
    public ModelAndView loginPage() {
        return new ModelAndView("back/login.jsp");
    }

    @RequestMapping("login.action")
    public void login(@RequestParam("id") int id, @RequestParam("password") String password, HttpServletResponse response,HttpSession httpSession) {
        Manager manager = managerService.login(id, password);
        httpSession.setAttribute("manager", manager);
        if(manager!=null){
            try {
                response.getWriter().write("success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
            try {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("用户名或密码错误！");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @RequestMapping("logout.action")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return new ModelAndView("login");
    }


    @RequestMapping(value = "back/updateManager.action",method = RequestMethod.POST)
    public void updateManager(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,HttpSession httpSession){
        Manager manager = (Manager) httpSession.getAttribute("manager");
        String nickname =  httpServletRequest.getParameter("nickname");
        String phone =  httpServletRequest.getParameter("phone");
        String email =  httpServletRequest.getParameter("email");
        manager.setNickname(nickname);
        manager.setPhone(phone);
        manager.setEmail(email);
        manager = managerService.updateManager(manager);
        Gson gson = new Gson();
        String jsonData = gson.toJson(manager);
        try {
            httpServletResponse.getWriter().write(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "back/checkOldPassword.action",method = RequestMethod.POST)
    public void checkOldPassword(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,HttpSession httpSession){
    Manager manager = (Manager) httpSession.getAttribute("manager");
    String password = httpServletRequest.getParameter("password");
    if(password.equals(manager.getPassword()))
        try {
            httpServletResponse.getWriter().write("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    else
        try {
            httpServletResponse.getWriter().write("error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "back/resetPassword.action",method = RequestMethod.POST)
    public void resetPassword(@RequestParam("newPassword")String newPassword, HttpSession httpSession, HttpServletResponse httpServletResponse){
        Manager manager = (Manager) httpSession.getAttribute("manager");
        manager.setPassword(newPassword);
        manager = managerService.updateManager(manager);
        if(manager!=null){
            httpSession.setAttribute("manager",manager);
            try {
                httpServletResponse.getWriter().write("success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                httpServletResponse.getWriter().write("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
