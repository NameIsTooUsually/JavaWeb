package com.chenhao.homework;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.*;

/*
假如用户下单，需要==同时==向 `orders` 和 `order_detail` 表中添加数据。
请定义一个测试方法用来模拟这一操作
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        //订单详情数据
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
        String sql = "INSERT INTO order_detail ()";

    }
}
