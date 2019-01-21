package com.tjl.mybatis.proxy;

/**
 * @author 0217319
 * @version V1.0
 * @Description: main  静态代理
 * @date 2018/12/26 11:06
 */
public class test {
    public static void main(String[] args) {
        TestInterface testInterface = new Test2();
        TestInterfaceProxy myProxy = new TestInterfaceProxy(testInterface);
        TestInterface proxy2 =  (TestInterface)myProxy.getProcyInstance();
        proxy2.test();
    }
}
