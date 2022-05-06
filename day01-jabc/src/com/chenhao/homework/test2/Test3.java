package com.chenhao.homework.test2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.*;

/*
假如用户下单，需要==同时==向 `orders` 和 `order_detail` 表中添加数据。
请定义一个测试方法用来模拟这一操作
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        //订单详情数据
        List<OrderDetail> list = getOrderDetails();
        //订单数据
        Orders orders = getOrders(list);

        //创建连接池对象
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
        //获取connection连接对象
        Connection connection = dataSource.getConnection();
        //编写sql语句
        String sql1 = "INSERT INTO order_detail(name,order_id,number,amount) value(?,?,?,?)";
        String sql2 = "INSERT INTO orders(id,number,status,order_time,pay_method,amount,phone,address) value(?,?,?,?,?,?,?,?)";
        try {
            //开启事务
            connection.setAutoCommit(false);
            //获取执行sql对象
            PreparedStatement psta1 = connection.prepareStatement(sql1);
            //设置值
            for (OrderDetail o : list) {
                psta1.setString(1,o.getName());
                psta1.setLong(2,orders.getId());
                psta1.setInt(3,o.getNumber());
                psta1.setDouble(4,o.getAmount());
                //执行
                psta1.executeUpdate();
            }
            //获取执行sql对象
            PreparedStatement psta2 = connection.prepareStatement(sql2);
            //设置值
            psta2.setLong(1,orders.getId());
            psta2.setString(2,orders.getNumber());
            psta2.setInt(3,orders.getStatus());
            psta2.setTime(4,new Time(orders.getOrderTime().getTime()));
            psta2.setInt(5,orders.getPayMethod());
            psta2.setDouble(6,orders.getAmount());
            psta2.setString(7,orders.getPhone());
            psta2.setString(8,orders.getAddress());
            //执行
            psta2.executeUpdate();

            //提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            connection.rollback();
        }


    }

    private static Orders getOrders(List<OrderDetail> list) {
        //订单数据
        Orders orders = new Orders();
        orders.setId(1);
        //使用UUID生成一个订单号
        String number = UUID.randomUUID().toString();
        orders.setNumber(number);
        //下单后默认就是 "待付款"
        orders.setStatus(1);
        //支付方式默认是 "微信支付"
        orders.setPayMethod(1);
        //下单时间即为系统当前时间
        orders.setOrderTime(new Date());
        //总金额，需要将订单中所有的商品的价格总和
        double amount = 0;
        for (OrderDetail detail : list) {
            amount += detail.getNumber() * detail.getAmount();
        }
        orders.setAmount(amount);
        //收货地址
        orders.setAddress("北京西三旗");
        //收货人手机号
        orders.setPhone("17621234235");
        return orders;
    }

    private static List<OrderDetail> getOrderDetails() {
        OrderDetail orderDetail = new OrderDetail();
        //订单中商品的名称
        orderDetail.setName("华为Meta50");
        //订单中该商品的数量
        orderDetail.setNumber(2);
        //该商品的单价
        orderDetail.setAmount(6000);

        OrderDetail orderDetail2 = new OrderDetail();
        //订单中商品的名称
        orderDetail2.setName("MetaBook X Pro");
        //订单中该商品的数量
        orderDetail2.setNumber(2);
        //该商品的单价
        orderDetail2.setAmount(9299);
        List<OrderDetail> list = new ArrayList<>();
        list.add(orderDetail);
        list.add(orderDetail2);
        return list;
    }
}
