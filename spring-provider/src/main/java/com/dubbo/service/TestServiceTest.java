package com.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.service
 * @Author tanjianglong
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
public class TestServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application.xml"});
        context.start();
        System.out.println("提供者服务已注册成功");
        try {
            System.in.read();//让此程序一直跑，表示一直提供服务
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
