package com.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.service
 * @Author xiaotantjl@163.com
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
public class ConsumerServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "application.xml" });
        context.start();
        TestService testService = (TestService) context.getBean("testService");
        System.out.println(testService.getName());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
