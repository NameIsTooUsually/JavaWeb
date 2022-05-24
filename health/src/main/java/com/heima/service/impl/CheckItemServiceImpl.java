package com.heima.service.impl;

import com.heima.mapper.CheckItemMapper;
import com.heima.pojo.CheckItem;
import com.heima.pojo.QueryDTO;
import com.heima.pojo.PageBeanResult;
import com.heima.service.CheckItemService;
import com.heima.utils.MyBatisConfigUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CheckItemServiceImpl implements CheckItemService {
    @Override
    public PageBeanResult selectByPage(QueryDTO queryDTO) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //设置查询字符串
        if (queryDTO.getQueryString() != null && queryDTO.getQueryString().length() > 0) {
            queryDTO.setQueryString("%" + queryDTO.getQueryString() + "%");
        }

        //确定分页是否合理，如果不合理，跳转到最近一页

        //查询总数
        int total = checkItemMapper.selectTotal(queryDTO);

        int begin = (queryDTO.getCurrentPage() - 1) * queryDTO.getPageSize();

        if (total < begin) {


            //计算分页起始编码
            int temp = total / queryDTO.getPageSize();
            if (temp == 0) {
                queryDTO.setCurrentPage(temp);
            } else {
                queryDTO.setCurrentPage((temp) * queryDTO.getPageSize());
            }
        } else if (total == begin) {
            int temp = total / queryDTO.getPageSize();
            queryDTO.setCurrentPage((temp - 1) * queryDTO.getPageSize());
        } else {
            queryDTO.setCurrentPage((queryDTO.getCurrentPage() - 1) * queryDTO.getPageSize());
        }


        //调用方法
        List<CheckItem> checkItems = checkItemMapper.selectByPage(queryDTO);

        //创建PageBeanResult对象
        PageBeanResult<CheckItem> pageBeanResult = new PageBeanResult<>();
        pageBeanResult.setTotal(total);
        pageBeanResult.setRows(checkItems);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        return pageBeanResult;
    }


    //通过id进行查询
    @Override
    public CheckItem findById(int id) {

        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //调用方法
        CheckItem checkItem = checkItemMapper.findById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return checkItem;

    }

    //添加
    @Override
    public boolean insertByOBJ(CheckItem checkItem) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //调用方法
        int i = checkItemMapper.insertByOBJ(checkItem);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        //判断
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    //通过id进行删除
    @Override
    public boolean deleteById(int id) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //调用方法
        int i = checkItemMapper.deleteById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        //判断
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    //更新
    @Override
    public int updateByOBJ(CheckItem checkItem) {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //调用方法
        int i = checkItemMapper.updateByOBJ(checkItem);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return i;
    }

    @Override
    public List<CheckItem> findAll() {
        //获取SQLSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取映射对象
        CheckItemMapper checkItemMapper = sqlSession.getMapper(CheckItemMapper.class);

        //调用方法
        List<CheckItem> items = checkItemMapper.findAll();
        return items;
    }
}
