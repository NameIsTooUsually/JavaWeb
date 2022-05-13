import com.chenhao.servlet_demo.mapper.UserMapper;
import com.chenhao.servlet_demo.polo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    @org.junit.Test
    public void Test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.validateUser("zhangsan", "123");
        System.out.println(user);
    }

    @org.junit.Test
    public void Testupdate() throws IOException {
        //创建一个对象
        User user = new User();
        user.setPassword("458");
        user.setUsername("牛牛");

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(user);
        sqlSession.commit();
        System.out.println(i);
    }
}
