package com.service.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *线程工具类
 * 线程池设置最大核心线程数后，该线程池中只会创建该数量的线程，提交到该线程池中的线程只会在这些创建的线程中执行，
 * 当核心线程都在执行任务时，则新提交的线程将处于排队队列中。
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

        //暂停提交线程
        ctp.shutdown();

        try {
            System.out.println(ctp.awaitTermination(5, TimeUnit.SECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
