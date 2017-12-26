package com.dubbo.service.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *线程工具类
 */
public class Executor {

    ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        ExecutorService ctp =  Executors.newFixedThreadPool  (1,new MyThreadFactory() );

        ctp.execute(new MyThread());
        ctp.execute(new MyThread());
        ctp.execute(new MyThread());
        ctp.execute(new MyThread());
        ctp.execute(new MyThread());
        ctp.execute(new MyThread());

        ctp.shutdown();
        try {
            System.out.println(ctp.awaitTermination(1200, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
