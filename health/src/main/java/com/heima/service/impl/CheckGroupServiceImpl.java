package com.heima.service.impl;

import com.heima.mapper.CheckGroupMapper;
import com.heima.pojo.CheckGroup;
import com.heima.pojo.PageBean;
import com.heima.pojo.QueryDTO;
import com.heima.service.CheckGroupService;
import com.heima.utils.MyBatisConfigUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);
        //System.out.println(checkGroup.getId());

        //调用方法,添加CheckGroup数据
        int _result = checkGroupMapper.insertByOBJ(checkGroup);
        if (_result > 0) {
            //说明checkGroup添加成功
            //获取主键
            int primaryKry = checkGroup.getId();

            //循环添加到t_checkgroup_checkitem/但是添加之前需要判断，checkItemids是否已经存在，如果不存才可以添加

            //根据t_checkGroup 的主键进行查询
            int[] byCheckItemIDs = checkGroupMapper.findByCheckGroupID(primaryKry);
            //如果返回的ID数组为长度为0，则说明没有是添加操作。如果返回的id数组长度不为0，则说明需要将重复的去除
            if(byCheckItemIDs.length>0){
                boolean flag = true;
                for (int i = 0; i < ids.length; i++) {
                    for (int j = 0; j < byCheckItemIDs.length; j++) {
                        if(byCheckItemIDs[j]==ids[i]){
                            //如果在byCheckItemIDs数组中查询到相等数，如果该CheckItemIDs已经存在，不需要再添加
                            flag = true;
                            break;
                        }else{
                            flag = false;
                        }
                    }
                    if(!flag){
                        //说明该CheckItemIDs没有添加过，执行添加方法
                        int result = checkGroupMapper.insertCheckGroup(primaryKry, ids[i]);
                        if (result <= 0) {
                            //释放资源
                            sqlSession.close();
                            return false;
                        }
                    }
                }
            }else{
                //初次添加t_checkgroup_checkitem信息
                for (int i = 0; i < ids.length; i++) {
                    //调用方法，对t_checkgroup_checkitem进行添加
                    int result = checkGroupMapper.insertCheckGroup(primaryKry, ids[i]);
                    if (result <= 0) {
                        //释放资源
                        sqlSession.close();
                        return false;
                    }
                }

            }
        } else {
            //释放资源
            sqlSession.close();
            return false;
        }

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
        return true;
    }


    //根据id进行查询
    @Override
    public CheckGroup findById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);

        //调用方法
        CheckGroup checkGroup = checkGroupMapper.findById(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return checkGroup;
    }

    @Override
    public int[] findCheckItemById(int id) {
        //获取sqlSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();

        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);

        //调用方法
        int[] ids = checkGroupMapper.findByCheckGroupID(id);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        return ids;

       /* //调用方法
        List<CheckGroup> checkGroups = checkGroupMapper.findCheckItemById(id);
        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

        //提取ID
        int[] ids = new int[checkGroups.size()];
        if(checkGroups.size()>0){
            for (int i = 0; i < checkGroups.size(); i++) {
                ids[i] = checkGroups.get(i).getId();
            }
        }
        return ids;*/
    }

    @Override
    public boolean editCheckGroup(CheckGroup checkGroup, int[] ids) {
        //获取sqlSession对象
        SqlSession sqlSession = MyBatisConfigUtils.getSqlSession();
        //获取Mapper对象
        CheckGroupMapper checkGroupMapper = sqlSession.getMapper(CheckGroupMapper.class);
        //调用方法,修改CheckGroup数据
        int _result = checkGroupMapper.updateByCheckGroupOBj(checkGroup);
        if (_result > 0) {
            //说明checkGroup修改成功
            //获取主键
            int primaryKry = checkGroup.getId();
            //循环添加到t_checkgroup_checkitem/但是添加之前需要判断，checkItemids是否已经存在，如果不存才可以添加
            //根据t_checkGroup 的主键进行查询
            int[] byCheckItemIDs = checkGroupMapper.findByCheckGroupID(primaryKry);
            //如果返回的ID数组为长度为0，则说明没有是添加操作。如果返回的id数组长度不为0，则说明需要将重复的去除
            if(byCheckItemIDs.length>0){
                boolean flag = true;
                for (int i = 0; i < ids.length; i++) {
                    for (int j = 0; j < byCheckItemIDs.length; j++) {
                        if(byCheckItemIDs[j]==ids[i]){
                            //如果在byCheckItemIDs数组中查询到相等数，如果该CheckItemIDs已经存在，不需要再添加
                            flag = true;
                            break;
                        }else{
                            flag = false;
                        }
                    }
                    if(!flag){
                        //说明该CheckItemIDs没有添加过，执行添加方法
                        int result = checkGroupMapper.insertCheckGroup(primaryKry, ids[i]);
                        if (result <= 0) {
                            //释放资源
                            sqlSession.close();
                            return false;
                        }
                    }
                }
            }else{
                //初次添加t_checkgroup_checkitem信息
                for (int i = 0; i < ids.length; i++) {
                    //调用方法，对t_checkgroup_checkitem进行添加
                    int result = checkGroupMapper.insertCheckGroup(primaryKry, ids[i]);
                    if (result <= 0) {
                        //释放资源
                        sqlSession.close();
                        return false;
                    }
                }
            }
        } else {
            //释放资源
            sqlSession.close();
            return false;
        }
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
        return true;
    }

}
