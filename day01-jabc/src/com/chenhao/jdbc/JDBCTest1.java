package com.chenhao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
JDBC快速入门
 */
public class JDBCTest1 {
    public static void main(String[] args) throws Exception {
        //1注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
        String userName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        //3编写sql
        String sql = "update tb_user set passWord = 123465 where id = 1";
        //4获取执行sql对象
        Statement statement = connection.createStatement();
        //5执行sql
        int i = statement.executeUpdate(sql);
        //6处理结果
        System.out.println(i);
        //7释放资源
        statement.close();
        connection.close();

    }
}
