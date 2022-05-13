package com.chenhao.servlet_demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryDemo {
    private static  SqlSessionFactory sqlSessionFactory;

    static{
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSessionFactory getSqlSessionFactory(){

        return sqlSessionFactory;
    }
}
