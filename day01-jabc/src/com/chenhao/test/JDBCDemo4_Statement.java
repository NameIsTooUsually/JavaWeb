package com.chenhao.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo4_Statement {
    /*

     */
    @Test
    public void testDML() throws SQLException {
        //获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String userName = "root";
        String password = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, password);

        //定义sql
        String sql = "update stu set name = '马云' where id = 1;";
        //获取执行sql的队形
        Statement statement = connection.createStatement();

        //开始执行
        try {
            //开启事务
            connection.setAutoCommit(false);
            //执行sql语句
            int i = statement.executeUpdate(sql);//执行完语句后，受影响的行数
            //处理结果
            System.out.println("i:"+i);
            if(i>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            //提交事务
            connection.commit();
        }catch (Exception e){
            connection.rollback();
            e.printStackTrace();
        }finally {
            //释放资源
            statement.close();
            connection.close();
        }

    }

    @Test
    public void testDDL() throws SQLException {
        //获取连接
        String url = "jdbc:mysql:///db1?useSSL=false";
        String userName = "root";
        String password = "123abc.";
        Connection connection = DriverManager.getConnection(url, userName, password);

        //定义sql
        String sql = "DROP DATABASE IF EXISTS db2;";
        //获取执行sql的队形
        Statement statement = connection.createStatement();

        //开始执行
        try {
            //开启事务
            connection.setAutoCommit(false);
            //执行sql语句
            int i = statement.executeUpdate(sql);//执行完语句后，可能是0,不能用返回值是否是0 来进行判断
            //处理结果
            System.out.println("i:"+i);
            /*if(i>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }*/
            //提交事务
            connection.commit();
        }catch (Exception e){
            connection.rollback();
            e.printStackTrace();
        }finally {
            //释放资源
            statement.close();
            connection.close();
        }
    }

}
