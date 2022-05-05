package com.chenhao.jdbc;

import java.sql.*;
import java.util.ArrayList;

/*
statement 执行查询语句
 */
public class JDBCTest2_ResultSet {
    public static void main(String[] args) throws Exception {
        //1获取连接对象
        String url = "jdbc:mysql:///test?useSSL=false";
        String userName = "root";
        String passWord = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, passWord);
        //2创建sql语句
        String sql = "select * from tb_user";
        //3获取执行sql对象
        Statement statement = connection.createStatement();
        //4执行sql
        ResultSet resultSet = statement.executeQuery(sql);
        //5处理结果 可以将查询的每个账户信息封装成对象，存入集合中
           //创建集合
        ArrayList<User> list = new ArrayList<>();
        while (resultSet.next()){
            //创建用户对象
            User user = new User();
            int id = resultSet.getInt(1);
            String uname = resultSet.getString(2);
            String pword = resultSet.getString(3);
            //添加元素
            user.setId(id);
            user.setName(uname);
            user.setPassword(pword);
            list.add(user);
        }
        System.out.println(list);
        //6释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}

class User{
    private  int id;
    private  String name;
    private  String password;

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

