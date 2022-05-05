package com.chenhao.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.media.sound.SoftTuning;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidTest {
    public static void main(String[] args) throws Exception {
        //1导Druid包
        //2设置配置文件
        //3加载配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        //4创建连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //5获取连接对象
        Connection connection = dataSource.getConnection();
        //编写sql语句
        String sql = "select * from tb_user where id = ?";
        //获取执行sql对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //设置参数
        statement.setInt(1,1);
        //执行sql
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String pword = resultSet.getString(3);
            System.out.println("id= "+id);
            System.out.println("name= "+name);
            System.out.println("pword= "+pword);
        }
    }
}
