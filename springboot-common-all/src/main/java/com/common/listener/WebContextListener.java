package com.common.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description:   https://blog.csdn.net/u011704894/article/details/44407145   详解
 * @date 2018/11/2 12:43
 */
public class WebContextListener implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //防止重复执行
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            System.out.println("------");
        }else{
            System.out.println("++++++++++++++");
        }
    }
}
