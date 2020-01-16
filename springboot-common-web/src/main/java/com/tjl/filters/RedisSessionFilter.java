package com.tjl.filters;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: jianglong.Tan
 * @Date: 2019/6/26 17:48
 * @Description: redis springsession
 */
public class RedisSessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("RedisSessionFilter---------");
        //TODO 自己实现session共享，
        //转换session  （传统session 放在容器中，如tomcat，   转换成spring session）
        //第三方存储 将转换后的session 存入 redis,db等
        //唯一的session id 利用 Cookie或者http请求头进行携带
        //实现session 操作  接口  put,remove update(有效时间)
        //需要session共享的服务使用该统一filter

        httpServletRequest.getSession().setAttribute("user","test");
        httpServletRequest.getSession().setMaxInactiveInterval(60 * 2);
        String user= (String) httpServletRequest.getSession().getAttribute("user");
        System.out.println("RedisSessionFilter---------user:" + user);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
