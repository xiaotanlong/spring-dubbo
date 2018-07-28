package springdubbo.springdubbofilter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "test")
public class LimitingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器=========="+this.hashCode());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到的请求=========="+servletRequest.getServletContext());
        servletRequest.setAttribute("data",System.currentTimeMillis());
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器=========="+this.hashCode());
    }
}
