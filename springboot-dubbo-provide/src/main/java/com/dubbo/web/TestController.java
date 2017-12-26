package com.dubbo.web;

import com.dubbo.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.web
 * @Author tanjianglong
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：1...;2....
 */
@RestController
@RequestMapping(value = "/test2")
public class TestController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    String queryName(){
        return exampleService.getName("tt");
    }


}
