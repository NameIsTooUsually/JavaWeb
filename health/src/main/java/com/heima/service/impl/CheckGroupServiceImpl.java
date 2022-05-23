package com.heima.service.impl;

import com.heima.mapper.CheckGroupMapper;
import com.heima.pojo.CheckGroup;
import com.heima.pojo.PageBean;
import com.heima.pojo.QueryDTO;
import com.heima.service.CheckGroupService;
import com.heima.utils.MyBatisConfigUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CheckGroupServiceImpl implements CheckGroupService {
    @Override
    public PageBean<CheckGroup> selectByPageAndCondition(QueryDTO queryDTO) {
        //获取sqlSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);

        //设置查询字符串
        if (queryDTO.getQueryString() != null && queryDTO.getQueryString().length() > 0) {
            queryDTO.setQueryString("%" + queryDTO.getQueryString() + "%");
        }

        //确定分页是否合理，如果不合理，跳转到最近一页

        //查询总数
        int total = checkGroupMapper.selectTotal(queryDTO);

        int begin = (queryDTO.getCurrentPage() - 1) * queryDTO.getPageSize();

        if (total <= begin) {
            //计算分页起始编码
            int temp = total / queryDTO.getPageSize();
            if (temp == 0) {
                queryDTO.setCurrentPage(temp);
            } else {
                queryDTO.setCurrentPage((temp - 1) * queryDTO.getPageSize());
            }
        } else {
            queryDTO.setCurrentPage((queryDTO.getCurrentPage() - 1) * queryDTO.getPageSize());
        }

        //分页查询
        List<CheckGroup> checkGroups = checkGroupMapper.selectByPageAndCondition(queryDTO);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

        //创建PageBean对象
        PageBean<CheckGroup> bean = new PageBean<>();
        bean.setRows(checkGroups);
        bean.setTotal(total);

        return bean;
    }

    @Override
    public boolean addGroup(CheckGroup checkGroup, int[] ids) {

        //获取sqlSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);

        //调用方法
        int primaryKey = checkGroupMapper.insertByOBJ(checkGroup);

        if (primaryKey > 0) {
            for (int i = 0; i < ids.length; i++) {
                int result = checkGroupMapper.insertCheckGroup(primaryKey, ids[i]);
                if (result <= 0) {
                    return false;
                }
            }
        }else {
            return false;
        }

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return true;
    }


}
