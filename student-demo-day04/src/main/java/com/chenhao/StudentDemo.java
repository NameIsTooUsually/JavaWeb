package com.chenhao;

import com.chenhao.mapper.ContractMapper;
import com.chenhao.mapper.StudentMapper;
import com.chenhao.pojo.Contract;
import com.chenhao.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDemo {
    @Test
    public void studentDemo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()){
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> students = mapper.selectAll();
            System.out.println(students);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void contractDemo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ContractMapper mapper = sqlSession.getMapper(ContractMapper.class);
            Contract byId = mapper.findById(2);
            System.out.println(byId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void contractDemo1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            ContractMapper mapper = sqlSession.getMapper(ContractMapper.class);
            List<Contract> all = mapper.findAll();
            for (Contract contract : all) {
                System.out.println(contract);
            }

        }
    }
}
