package com.web;

import com.common.session.UserSession;
import com.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.web
 * @Author xiaotantjl@163.com
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：前后端分离的  接口暴露层   Controller （只负责接口暴露    具体的服务提供方根据业务量还部署 集群)
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    String queryName(){
        UserSession.set("usersession","我是用户信息-con");
        return exampleService.getName("tt");
    }
}
