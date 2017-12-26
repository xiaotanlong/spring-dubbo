package com.dubbo.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.service
 * @Author tanjianglong
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
public class TestServiceTest {
    private static boolean d ;
    public static void main(String[] args) throws InterruptedException {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"application.xml"});
        context.start();
        System.out.println("提供者服务已注册成功");
        try {
            System.in.read();//让此程序一直跑，表示一直提供服务
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //大int 不可变类
        BigInteger b = new BigInteger("20",3);
        //System.out.print(b);
        //线程同步

        Thread test = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!d)
                {
                    System.out.println(i++);
                }
            }
        });

        //test.start();

        TimeUnit.SECONDS.sleep(1);
        d= true;

        List<String> ss = new ArrayList<String>();
        ss.add("a");ss.add("a2");ss.add("a3");ss.add("a4");ss.add("a5");ss.add("a6");
        for (String s : ss)
        {
            //if(s.endsWith("a2")) ss.remove(s);
        }
        for (int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
            System.out.println(ss.size());
            if(i==6)
            {
                ss.remove(ss.get(i));
                System.out.println(ss.size()+"===");
            }

        }

        ExecutorService executor = Executors.newSingleThreadExecutor();
        //executor.submit()
    }
}
