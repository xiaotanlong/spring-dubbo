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
 * 修改记录：1.dubbo服务本身也可以暴露接口   不过如果要水平分层的话  这边就不需要这个  Controller
 */
@RestController
@RequestMapping(value = "/test2")
public class TestController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    String queryName(){
        UserSession.set("usersession","我是用户信息-pro");
        return exampleService.getName("tt");
    }


}
