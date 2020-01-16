package com.tjl.mybatis.proxy;

/**
 * @author xiaotantjl@163.com
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/12/26 11:09
 */
public class Test1 implements TestInterface {
    @Override
    public String test() {
        System.out.println("My is Test 1 ------------------");
        return "My is Test 1 ------------------";
    }
}
