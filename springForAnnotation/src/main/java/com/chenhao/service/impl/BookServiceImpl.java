package com.chenhao.service.impl;

import com.chenhao.dao.BookDao;
import com.chenhao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("BookService")
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    public void service() {
        System.out.println("bookService show ....");
        bookDao.show();
    }
}
