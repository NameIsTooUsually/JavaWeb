package com.chenhao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3_Connection {
    public static void main(String[] args) throws SQLException {
        //2获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        //可以简写,中间的地址和端口好可以省略
        //String url = "jdbc:mysql://da1"
        String userName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        //3写sql语句
        String sql = "UPDATE stu SET math = 60 WHERE id =1;";
        String sql2 = "UPDATE stu SET math = 100 WHERE id =2;";
        //4获取执行对象
        Statement statement = connection.createStatement();

        try {
            //开启事务
            connection.setAutoCommit(false);
            //5执行
            int execute1 = statement.executeUpdate(sql);
            //6处理结果
            System.out.println("execute1:"+execute1);
            // 在这这里手动写一个错误，验证是否会修改成成功
            //int a = 3/0;

            //5执行
            int execute2 = statement.executeUpdate(sql2);
            //6处理结果
            System.out.println("execute2:"+execute2);
            //提交事务  如果运行到这一步，则说明没有问题，就需要手动提交事务
            connection.commit();
        } catch (Exception e) {
            //如果程序出现异常，就需要回滚事务
            connection.rollback();
            e.printStackTrace();

        }finally {
            //7释放资源
            statement.close();
            connection.close();
        }
    }
}
