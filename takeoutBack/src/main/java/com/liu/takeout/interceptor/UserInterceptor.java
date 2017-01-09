package com.liu.takeout.interceptor;

import com.liu.takeout.entity.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by anybody on 2016/12/19.
 */
public class UserInterceptor  implements HandlerInterceptor{

    String []allowsUrls;

    public void setAllowsUrls(String[] allowsUrls) {
        this.allowsUrls = allowsUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI().replace(request.getContextPath(),"");
        if(null != allowsUrls && allowsUrls.length>1){
            for(String url : allowsUrls){
                if (requestUrl.contains(url))
                    return true;
            }
        }
        Manager manager = (Manager)request.getSession().getAttribute("manager");
        System.out.println("\n"+manager+"\n");
        if(manager != null)
            return true;
        else{
            request.getRequestDispatcher("back/login.jsp").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
