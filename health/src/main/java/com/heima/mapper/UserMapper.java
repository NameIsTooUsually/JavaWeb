package com.heima.mapper;

import com.heima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    //根据username 和password查询用户
    @Select("select * from t_user where username = #{username} and password = #{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /*//分页查询
    List<CheckItem> selectByPage(@Param("begin") int begin, @Param("pageSize")int pageSize);*/

    /*//查询总数
    @Select("select count(*) from t_checkitem")
    int selectTotal();*/

    /*//通过ID进行查询
    @Select("select * from t_checkitem where id = #{id}")
    CheckItem findById(int id);*/

   /* //新增
    void insertByOBJ(CheckItem checkItem);*/

   /* //通过id删除
    @Delete("delete from t_checkitem where id = #{id}")
   int deleteById(int id);*/

 /*   //修改
    int updateByOBJ(CheckItem checkItem);*/
}
