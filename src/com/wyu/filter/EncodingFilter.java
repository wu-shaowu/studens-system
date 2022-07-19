package com.wyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter",value = "/*")//value = "/*"表示所有地方启动滤波器，urlPatterns = { "/LoginServlet","/register"},则表示固定两个
public class EncodingFilter implements Filter {
    //服务器关闭时执行
    public void destroy() {
        System.out.println("过滤器销毁了");
    }

    //过滤器执行
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器执行了");
        //处理中文乱码问题
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    //初始化时执行，服务器启动时执行
    public void init(FilterConfig config) throws ServletException {

        System.out.println("过滤器初始化");
    }

}
