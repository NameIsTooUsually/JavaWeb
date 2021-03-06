package com.chenhao.servlet_demo.login;

import com.chenhao.servlet_demo.mapper.UserMapper;
import com.chenhao.servlet_demo.polo.User;
import com.chenhao.servlet_demo.util.SqlSessionFactoryDemo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/LoginDemo")
public class LoginDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //mybatis 完成查询
        /*InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);*/

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryDemo.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.validateUser(username, password);
        sqlSession.close();

        //获取对应的字符输出流，并设置contenttupe
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user!=null){
            writer.write(username+"你好");
        }else{
            writer.write("用户名或者密码不匹配<br><a href='http://localhost/baidu' target='_blank'>登录</a>");
        }
    }
}
