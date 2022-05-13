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

@WebServlet("/RegisterDemo")
public class RegisterDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //username = URLDecoder.decode(new String(URLEncoder.encode(username, "ISO_8859_1").getBytes()), "UTF-8");

       /* InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);*/

        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryDemo.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        User user1 = mapper.selectByUserName(username);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(user1==null){
            mapper.updateUser(user);
            sqlSession.commit();
            sqlSession.close();
            writer.write(username+" 恭喜你注册成功成功");
        }else{

            writer.write("用户名已存在");
        }
    }
}
