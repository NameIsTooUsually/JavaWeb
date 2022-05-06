package com.chenhao.homework.test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class RunnableOrders implements Runnable{
    private Orders orders;
    private Connection connection;
    private String sql2 = "INSERT INTO orders(id,number,status,order_time,pay_method,amount,phone,address) value(?,?,?,?,?,?,?,?)";
    @Override
    public void run() {
        //获取执行sql对象
        try {
            PreparedStatement psta = connection.prepareStatement(sql2);
            //设置值
            psta.setLong(1,orders.getId());
            psta.setString(2,orders.getNumber());
            psta.setInt(3,orders.getStatus());
            psta.setTime(4,new Time(orders.getOrderTime().getTime()));
            psta.setInt(5,orders.getPayMethod());
            psta.setDouble(6,orders.getAmount());
            psta.setString(7,orders.getPhone());
            psta.setString(8,orders.getAddress());
            //执行
            psta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RunnableOrders() {
    }

    public RunnableOrders(Orders orders, Connection connection) {
        this.orders = orders;
        this.connection = connection;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
