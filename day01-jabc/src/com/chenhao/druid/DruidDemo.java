package com.chenhao.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
        public static void main(String[] args) throws Exception {
            //1导入Druid。jar包
            //2定义配置文件
            //3加载配置文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
            //4获取数据库连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            //5获取连接
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        }
}
