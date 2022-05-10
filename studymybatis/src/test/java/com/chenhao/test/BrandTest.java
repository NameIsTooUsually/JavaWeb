package com.chenhao.test;

import com.chenhao.mapper.BrandMapper;
import com.chenhao.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BrandTest {
    SqlSession sqlSession;
    BrandMapper brandMapper;

    @Before
    public void before() throws IOException {
        //加载mybatis核心配置文件
        String resource = "mybatis-config";
        InputStream is = Resources.getResourceAsStream(resource);
        //创建sqlsessionfactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //通过工厂对象获取sqlsession
        sqlSession = sqlSessionFactory.openSession();
        //获取接口映射文件对象
        brandMapper = sqlSession.getMapper(BrandMapper.class);
    }

    @After
    public void after() {
        //释放资源
        sqlSession.close();
    }

    @Test
    public void findAllTest() {
        //测试查询所有
        List<Brand> brands = brandMapper.findAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    public void findOneTest(){
        //测试查询详情
        Integer id = 3;
        Brand brand = brandMapper.findOne(id);
        System.out.println(brand);
    }

    @Test
    public void findByFixConditionTest(){
        //根据固定个数的条件进行查询
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";

        //对字符串进行转换
        brandName = '%'+brandName+'%';
        companyName = '%'+companyName+'%';

        List<Brand> brands = brandMapper.findByFixConditions(brandName, companyName, status);
        for (Brand brand : brands) {
            System.out.println(brand);
        }
    }

    @Test
    public void findByConditionsTest(){
        //根据不固定个数的字符串进行查询
        Integer id = 1;
        String brandName = "华为";
        String companyName = "华为";
        //对字符串进行转换
        brandName = '%'+brandName+'%';
        companyName = '%'+companyName+'%';

        Integer ordered = 100;
        Integer status = 1;
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.findByConditions(brand);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }

    }

    @Test
    public void findByconditionTest(){
        Integer status = 1;
        String brandName = "华为";
        String companyName = "华为";

        //对字符串进行转换
        brandName = '%'+brandName+'%';
        companyName = '%'+companyName+'%';


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        List<Brand> brands = brandMapper.findByCondition(null);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }
    }

    @Test
    public void addOneTest(){
        // 基础添加
        String brandName = "小米无线鼠标";
        String companyName = "小米科技有限公司";
        Integer ordered = 100;
        String description = "最好用的无线鼠标";
        Integer status = 1;
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);

        int i = brandMapper.addOne(brand);
        //提交事务
        sqlSession.commit();
        System.out.println(i);
    }


    @Test
    public void addOneReturnPKTest(){
        //添加并返回主键
        String brandName = "奇瑞汽车";
        String companyName = "奇瑞汽车有限公司";
        Integer ordered = 100;
        String description = "奇瑞奇瑞修车排队";
        Integer status = 1;
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(ordered);
        brand.setDescription(description);
        brand.setStatus(status);

        int i = brandMapper.addOneReturnPK(brand);

        //提交事务
        sqlSession.commit();
        //返回的主键封装到id中，这里获取id并进行打印
        System.out.println(brand.getId());
        System.out.println(i);
    }

    @Test
    public void updateByOBJTest(){
        //根据id 修改数据，只修改提交了的
        Brand brand = new Brand();
        brand.setId(8);
        brand.setStatus(1);
        int i = brandMapper.updateByOBJ(brand);
        //提交事务
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void deleteByIdTest(){
        //根据id，一次删除一行
        int i = brandMapper.deleteByid(6);
        sqlSession.commit();
        System.out.println(i);
    }

    @Test
    public void deleteByIdsTest(){
        int[] ids = {5,7,8,9};
        int i = brandMapper.deleteByIds(ids);
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void findByIdAnnotationTest(){
        Brand brand = brandMapper.findByIdAnnotation(2);
        System.out.println(brand);
    }

}
