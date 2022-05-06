package com.chenhao.homework.test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RunnableOrder_detail implements Runnable {
    private List<OrderDetail> list;
    private Orders orders;
    private Connection connection;
    private String sql1 = "INSERT INTO order_detail(name,order_id,number,amount) value(?,?,?,?)";

    @Override
    public void run() {
        //获取执行sql对象
        try {
            PreparedStatement psta = connection.prepareStatement(sql1);
            //设置值
            for (OrderDetail o : list) {
                psta.setString(1,o.getName());
                psta.setLong(2,orders.getId());
                psta.setInt(3,o.getNumber());
                psta.setDouble(4,o.getAmount());
                //执行
                psta.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RunnableOrder_detail(List<OrderDetail> list, Orders orders, Connection connection) {
        this.list = list;
        this.orders = orders;
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public RunnableOrder_detail() {
    }

    public List<OrderDetail> getList() {
        return list;
    }

    public void setList(List<OrderDetail> list) {
        this.list = list;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
