package test;

import com.chenhao.config.SpringConfig;
import com.chenhao.dao.BookDao;
import com.chenhao.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;


public class TestForAnnotation {
    @Test
    public void test(){
        //创建IOC容器
        ClassPathXmlApplicationContext cpxc = new ClassPathXmlApplicationContext("application.xml");
        //创建bean对象
        BookDao bookDao = (BookDao) cpxc.getBean("BookDao");
        bookDao.show();
        BookService bookService = cpxc.getBean(BookService.class);
        System.out.println(bookService);
    }
    @Test
    public void test2(){
        ApplicationContext cpxc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //创建bean对象
        BookDao bookDao = (BookDao) cpxc.getBean("BookDao");
        bookDao.show();
        BookService bookService = cpxc.getBean(BookService.class);
        System.out.println(bookService);
    }
    @Test
    public void test3(){
        AnnotationConfigApplicationContext cpxc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //创建bean对象
        BookDao bookDao1 = (BookDao) cpxc.getBean("BookDao");
        BookDao bookDao2 = (BookDao) cpxc.getBean("BookDao");
        System.out.println(bookDao1);
        System.out.println(bookDao2);
        cpxc.close();

    }

    @Test
    public void test4(){
        AnnotationConfigApplicationContext cpxc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //创建bean对象
        BookService bookService = (BookService) cpxc.getBean("BookService");

        bookService.service();

    }
    @Test
    public void test5(){
        AnnotationConfigApplicationContext cpxc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //创建bean对象
        DataSource dataSource = (DataSource) cpxc.getBean(DataSource.class);

        System.out.println(dataSource);

    }


}
