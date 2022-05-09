package com.chenhao.test;

import com.chenhao.mapper.StoreMapper;
import com.chenhao.pojo.Store;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.action.PutAllAction;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

public class StoreTest {
    SqlSession sqlSession;
    StoreMapper sessionMapper;

    @Before
    public void before() throws IOException {
        String resouce = "mybatis-config";
        InputStream is = Resources.getResourceAsStream(resouce);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sessionFactory.openSession();
        sessionMapper = sqlSession.getMapper(StoreMapper.class);
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void insertTest() {
        // "黄蓉","441322199511114212","蓉儿叫花鸡","美食","北京市朝阳区","18933283299",1,"2020-08-08 10:00:30"

        String shopOwner = "黄蓉";
        String idNumber="441322199511114212";
        String name = "蓉儿叫花鸡";
        String industry = "美食";
        String area = "北京市朝阳区";
        String phone = "18933283299";
        Integer status = 1;
        LocalDateTime auditTime = LocalDateTime.of(2020,8,8,10,0,30);
        Store store = new Store(null,shopOwner,idNumber,name,industry,area,phone,status,auditTime);
        int i = sessionMapper.insert(store);
        //提交事务
        sqlSession.commit();
        System.out.println(i);

    }
    @Test
    public void deleteById(){
        //查询 `id=1` 的数据，并将数据封装到实体类对象中
        int i = sessionMapper.deleteByid(1);
        //提交事务
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void findAll(){
        List<Store> stores = sessionMapper.findAll();
        for (Store store : stores) {
            System.out.println(store);
        }
    }
    @Test
    public void findById(){
        Store store = sessionMapper.findByid(2);
        System.out.println(store);
    }
    @Test
    public void setById(){
        Store store = new Store();
        store.setId(2);
        store.setArea("北京昌平区");
        store.setPhone("13629224217");
        int i = sessionMapper.setById(store);
        System.out.println(i);
        sqlSession.commit();
    }
    @Test
    public void deleteByIds(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        sessionMapper.deleteByIds(list);
        sqlSession.commit();
    }

    @Test
    public void findCondition(){
        Map<String,Object> condition = new HashMap<>();
        String phone = "18933283299";
        LocalDateTime startTime = LocalDateTime.of(2021,1,1,20,20,0);
        LocalDateTime endTime = LocalDateTime.of(2022,5,9,10,6,50);
        Integer status = 1;
        String idNumber = "441322199610205317";
        condition.put("idNumber",idNumber);
        condition.put( "phone",null);
        condition.put("startTime",null);
        condition.put("endTime",null);
        condition.put("status",null);

        List<Store> stores = sessionMapper.findCondition(condition);
        for (Store store : stores) {
            System.out.println(store);
        }
    }
    @Test
    public void insertReturnFK(){
        String shopOwner = "周芷若";
        String idNumber="441322199511114223";
        String name = "九阴真经";
        String industry = "武术";
        String area = "芜湖中江桥";
        String phone = "18901012020";
        Integer status = 1;
        LocalDateTime auditTime = LocalDateTime.of(2019,8,8,10,0,30);
        Store store = new Store(null,shopOwner,idNumber,name,industry,area,phone,status,auditTime);

        int i = sessionMapper.insertReturnPK(store);
        sqlSession.commit();
        System.out.println(i);
    }
}
