package com.chenhao.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.chenhao.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class ExampleDemo {
    /*
    查询所有
    1 sql：select * from tb_brand；
     */
    @Test
    public void selectAllDemo() throws Exception {
        //1获取连接对象(通过连接池获取连接对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "select * from tb_brand";
        //获取preparestatement对象
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行ssql
        ResultSet resultSet = statement.executeQuery();

        //处理结果
            //创建集合
        ArrayList<Brand> brands = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            Brand brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);
        }
        System.out.println(brands);
        //释放资源
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void addDemo() throws Exception {
        //页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int orderd = 1;
        String description = "一年卖出3亿多杯";
        int status = 1;


        //1获取连接对象(通过连接池获取连接对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status)" +
                "value (?,?,?,?,?)";
        //获取preparestatement对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //设置值
        statement.setString(1,brandName);
        statement.setString(2,companyName);
        statement.setInt(3,orderd);
        statement.setString(4,description);
        statement.setInt(5,status);
        //执行ssql
        int i = statement.executeUpdate();

        //处理结果
        System.out.println(i>0);
        //释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void updateDemo() throws Exception {
        //页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int orderd = 1000;
        String description = "一年卖出7亿多杯";
        int status = 1;
        int id = 4;


        //1获取连接对象(通过连接池获取连接对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "update tb_brand set brand_name = ?" +
                ",company_name = ?," +
                "ordered = ?," +
                "description = ?," +
                "status = ? " +
                "where id = ?";
        //获取preparestatement对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //设置值
        statement.setString(1,brandName);
        statement.setString(2,companyName);
        statement.setInt(3,orderd);
        statement.setString(4,description);
        statement.setInt(5,status);
        statement.setInt(6,id);
        //执行ssql
        int i = statement.executeUpdate();

        //处理结果
        System.out.println(i>0);
        //释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void deleteByIdDemo() throws Exception {
        //页面提交的参数
        int id = 4;


        //1获取连接对象(通过连接池获取连接对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "delete from tb_brand where id = ?";
        //获取preparestatement对象
        PreparedStatement statement = connection.prepareStatement(sql);
        //设置值

        statement.setInt(1,id);
        //执行ssql
        int i = statement.executeUpdate();

        //处理结果
        System.out.println(i>0);
        //释放资源
        statement.close();
        connection.close();
    }
}
