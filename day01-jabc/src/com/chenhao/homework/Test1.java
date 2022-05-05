package com.chenhao.homework;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
/*
现数据库中有一张 `student` 表，表结构如下图所示。按照要求使用JDBC+Druid数据源对表中数据进行操作
1. 查询出所有的数据，并将每一条数据封装到Student实体类对象中存储到List集合中
2. 查询出id是 `2` 的数据并封装到一个 Student 对象中
3. 往表中添加如下数据"周芷若"，20，“北京昌平区”，“女”，“13645785667”，“1315-05-21”
4. 修改 `张三丰` 的家庭住址为 `北京海淀区`
5. 删除id为 `2` 的数据
*/
public class Test1 {
    public static void main(String[] args) throws Exception {
        //1创建数据库连接池
        //创建properties 对象
        Properties properties = new Properties();
        //加载配置文件
        //类加载器方式获取输入流
        /*InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties");
        properties.load(inputStream);*/
        properties.load(new FileInputStream("C:\\Develop\\project\\javaWeb\\day01-jabc\\src\\druid.properties"));
        //创建数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //method1(dataSource);
        //method2(dataSource);
        //method3(dataSource);
        //method4(dataSource);
        method5(dataSource);
    }

    private static void method5(DataSource dataSource) throws SQLException {
        //删除id为 `2` 的数据
        //编写sql语句
        String sql = "delete from student where id = ?";
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        //获取sql执行者对象
        PreparedStatement pstate = connection.prepareStatement(sql);
        //设置参数
        pstate.setInt(1,2);
        //执行sql
        pstate.executeUpdate();
    }

    private static void method4(DataSource dataSource) throws SQLException {
        //修改 `张三丰` 的家庭住址为 `北京海淀区`
        //编写sql语句
        String sql = "update student set address = ? where `name`= ? ";
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        //获取sql执行者对象
        PreparedStatement pstate = connection.prepareStatement(sql);
        //设置参数
        pstate.setString(1,"北京海淀区");
        pstate.setString(2,"张三丰");
        //执行sql
        pstate.executeUpdate();
    }

    private static void method3(DataSource dataSource) throws SQLException {
        //往表中添加如下数据"周芷若"，20，“北京昌平区”，“女”，“13645785667”，“1315-05-21”
        //编写sql语句
        String sql = "insert into student (name,age,address,gender,phone,birthday)value (?,?,?,?,?,?)";
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        //获取sql执行者对象
        PreparedStatement pstate = connection.prepareStatement(sql);
        //设置参数
        pstate.setString(1,"周芷若");
        pstate.setInt(2,20);
        pstate.setString(3,"北京昌平区");
        pstate.setString(4,"女");
        pstate.setString(5,"13645785667");
        pstate.setDate(6, Date.valueOf(LocalDate.of(1315,5,21)));
        //执行sql
        pstate.executeUpdate();
    }

    private static void method2(DataSource dataSource) throws SQLException {
        //查询出id是 `2` 的数据并封装到一个 Student 对象中
        //编写sql语句
        String sql = "SELECT * FROM student WHERE id=?";
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        //获取sql执行者对象
        PreparedStatement pstate = connection.prepareStatement(sql);
        //设置参数
        pstate.setInt(1,2);
        //执行sql
        ResultSet rs = pstate.executeQuery();
        Student student = new Student();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String address = rs.getString(4);
            String gender = rs.getString("gender");
            String phone = rs.getString(6);
            Date birthday = rs.getDate(7);
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);
            student.setGender(gender);
            student.setPhone(phone);
            student.setBirthday(birthday);
        }
        System.out.println(student);
    }

    private static void method1(DataSource dataSource) throws SQLException {
        //编写sql语句
        //查询出所有的数据，并将每一条数据封装到Student实体类对象中存储到List集合中
        String sql = "SELECT * FROM student";
        // 获取数据库连接对象
        Connection connection = dataSource.getConnection();
        //获取sql执行者对象
        PreparedStatement pstate = connection.prepareStatement(sql);
        //执行sql
        ResultSet rs = pstate.executeQuery();
        //创建集合
        ArrayList<Student> list = new ArrayList<>();
        //处理结果
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String address = rs.getString(4);
            String gender = rs.getString("gender");
            String phone = rs.getString(6);
            Date birthday = rs.getDate(7);
            //创建student对象
            Student student = new Student(id, name, age, address, gender, phone, birthday);
            list.add(student);

        }
        System.out.println(list);
    }

}
