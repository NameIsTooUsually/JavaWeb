package com.chenhao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//快速入门jdbc
public class JDBCDemo2_DriverManager {
    public static void main(String[] args) throws Exception {
        //1注册驱动 （可以不写）
        //Class.forName("com.mysql.jdbc.Driver");
        //2获取链接:如果链接的是本机mysql 并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "123abc.";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3定义sql，写sql语句
        String sql = "UPDATE stu SET math = 100.00 WHERE id = 1";
        //4获取执行sql的对象
        Statement statement = connection.createStatement();
        //5执行sql
        int  execute = statement.executeUpdate(sql);
        //6处理结果
        System.out.println(execute);
        //7释放资源
        statement.close();
        connection.close();
    }
}
