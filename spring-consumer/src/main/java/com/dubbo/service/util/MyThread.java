package com.dubbo.service.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread implements Runnable {


    public void run(){
        System.out.println("complete a task!!!");
    }
}
