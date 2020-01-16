package com.tjl.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: 代理类  代理的执行  类的  指定方法
 * 在代理执行中  还可以进行增强
 * @date 2018/12/26 10:40
 */
public class TestInterfaceProxy implements InvocationHandler{
    private TestInterface testInterface;
    public TestInterfaceProxy(TestInterface testInterface){
        super();
        this.testInterface = testInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doInvokeBefore();
        Object result = method.invoke(testInterface,args);
        doInvokeAfter();
        return result;
    }

    public void doInvokeBefore(){
        System.out.println("do some  before ==== ");
    }
    public void doInvokeAfter(){
        System.out.println("do some  After ==== ");
    }

    //将当前对象包装成 一个接口的 代理对象
    public Object getProcyInstance(){
        return Proxy.newProxyInstance(testInterface.getClass().getClassLoader(),testInterface.getClass().getInterfaces(),this);
    }
}
