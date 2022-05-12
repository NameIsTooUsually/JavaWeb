package com.chenhao.servlet_demo.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(urlPatterns = "/ServletDemo1",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet启动了！！！！");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化开始了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁开始了");
    }
}
