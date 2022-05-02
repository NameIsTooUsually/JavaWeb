package com.chenhao.jdbc;

import com.chenhao.pojo.Stu;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCDemo5_Resultset {

    @Test
    public void testResultsetByNumber() throws Exception {
        //获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String useName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, useName, passWord);
        // 定义sql
        String sql = "select * from stu;";
        //获取statement对象
        Statement statement = connection.createStatement();
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        //处理结果
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double math = resultSet.getDouble(6);
            System.out.println(id+";"+name+"数学成绩为："+math);
            System.out.println("--------------------------");
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
    @Test
    public void testResultsetByColumn() throws Exception {
        //获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String useName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, useName, passWord);
        // 定义sql
        String sql = "select * from stu;";
        //获取statement对象
        Statement statement = connection.createStatement();
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        //处理结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double math = resultSet.getDouble("math");
            System.out.println(id+";"+name+"数学成绩为："+math);
            System.out.println("--------------------------");
        }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
    @Test
    public void testResultseToArrayList() throws Exception {
        //获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String useName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, useName, passWord);
        // 定义sql
        String sql = "select id,name,age,gender from stu;";
        //获取statement对象
        Statement statement = connection.createStatement();
        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //创建一个集合
        ArrayList<Stu> stus = new ArrayList<>();
        //处理结果
        while (resultSet.next()){
            //表的一行数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            //封装成一个对象
            Stu stu = new Stu(id, name, age, gender);
            //存入集合中
            stus.add(stu);
    }
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();

        //打印集合
        System.out.println(stus);
    }
}
