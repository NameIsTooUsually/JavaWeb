package com.chenhao.dao.impl;

import com.chenhao.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("BookDao")
@Scope("singleton")
public class BookDaoImpl implements BookDao {
    @Value("${name}")
    private String str;

    public void show() {
        System.out.println("bookDao show 。。。"+str);
    }
    @PostConstruct
    public void init() {
        System.out.println("init 。。。");
    }
    @PreDestroy
    public void destory() {
        System.out.println("destory 。。。");
    }
}
