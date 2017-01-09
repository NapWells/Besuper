package com.liu.takeout.aopLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;


@Aspect
@Component
public class ManagerLog {

    @Around(value = "execution(* com.liu.takeout.service.impl.RiderServiceImpl.updateRiderStatus(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("------------------------------------");
        File file = new File("logs/serviceLog.log");
        if (!file.exists()){
            file.createNewFile();
        }
        HttpSession session = (HttpSession) RequestContextHolder.currentRequestAttributes().
                resolveReference(RequestAttributes.REFERENCE_SESSION);
        Object obj = null;
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file);
            fileWriter.write("环绕前增强....."+session.getAttribute("manager")+"-----"+ System.currentTimeMillis());
            obj = proceedingJoinPoint.proceed();
            fileWriter.write("\\r\\n");
            fileWriter.write("环绕后增强....."+obj+"----"+System.currentTimeMillis());
            fileWriter.write("\\r\\n");
        }catch (Exception e){
            System.out.println(e.getCause());
        } finally {

            if (fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }
            return obj;
        }
    }
}
