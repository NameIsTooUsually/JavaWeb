package com.chenhao.test;

import org.junit.Test;

import java.sql.*;

public class JDBSDemo6_UserLogin {
    @Test
    public void testInject() throws SQLException {
        //创建连接
        String url = "jdbc:mysql:///test?useSSL=false";
        String userName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        //获取执行sql对象
        Statement statement = connection.createStatement();

        //获取用户输入的名称密码，这里写两个字符串
        //正确的用户名和密码
        /*String name = "zhangsan";
        String word = "123456";*/

        //随便写的用户名和sql注入的密码密码
        String name = "rsegyfgd";
        String word = "' or 'a' = 'a";
        //创建sql语句
        String sql = "SELECT * FROM tb_user WHERE userName = '"+name+"'and passWord = '"+word+"';";

        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //处理sql
        if(resultSet.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
