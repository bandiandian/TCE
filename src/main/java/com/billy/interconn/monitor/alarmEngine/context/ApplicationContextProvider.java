package com.billy.interconn.monitor.alarmEngine.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 新建应用上下文
 * Author: bandd
 * Mailto:bandd@haier.com
 * On:  2017/2/9 16:05
 */
@Component
@Order(-1)
public class ApplicationContextProvider implements ApplicationContextAware{

    private static ApplicationContext context;

    private ApplicationContextProvider(

    ){}


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("load applicationContext");
        context  = applicationContext;

    }

    public  static <T> T getBean(String name,Class<T> aClass){
        System.out.println("context.getBean test");
        return context.getBean(name,aClass);
    }
}
