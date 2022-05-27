package com.chenhao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.chenhao.dao","com.chenhao.service"})
@PropertySource("jabc.properties")
@Import({JdbcConfig.class})
public class SpringConfig {

    //定义一个方法获得获得要管理的对象

}
