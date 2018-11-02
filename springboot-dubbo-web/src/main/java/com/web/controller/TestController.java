package com.web.controller;

import com.common.session.UserSession;
import com.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName spring-dubbo
 * @PackageName com.dubbo.web
 * @Author xiaotantjl@163.com
 * @CreatedTime 2017/10/26.
 * @Description :Plase give some message
 * 修改记录：
 *          1.2018-11-1 web 模块   提供接口  并负责后台页面的展示
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping(value = "queryName", method = RequestMethod.GET)
    @ResponseBody
    public String queryName(){
        UserSession.set("usersession","我是用户信息-con");
        return exampleService.getName("tt");
    }

    @RequestMapping(value = "topage", method = RequestMethod.GET)
    public String topage(Model model){
        System.out.println("-----我是页面跳转");
        model.addAttribute("name", "我是页面跳转");
        return "hello";
    }
}
