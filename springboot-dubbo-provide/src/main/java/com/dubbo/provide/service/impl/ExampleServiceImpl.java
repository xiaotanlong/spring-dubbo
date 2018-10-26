package com.dubbo.provide.service.impl;

import com.dubbo.service.ExampleService;
import com.dubbo.session.UserSession;
import org.springframework.stereotype.Service;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.provide.service.impl
 * @Author tanjianglong
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
@Service("axempleService")
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String getName(String name) {
        Object o = UserSession.get("usersession");

        return name + "dubbo ------" + o.toString();
    }
}
