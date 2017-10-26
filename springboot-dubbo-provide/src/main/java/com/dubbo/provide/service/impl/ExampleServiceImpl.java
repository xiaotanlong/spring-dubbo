package com.dubbo.provide.service.impl;

import com.dubbo.service.ExampleService;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.provide.service.impl
 * @Author tanjianglong
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String getName(String name) {
        return name + "dubbo ------";
    }
}
