package com.pj.mapper;

import com.pj.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Usermapper {
    //查询全部用户信息
    List<Users> getall();

    //按id查询学生
    Users findbyid(int id);

    //按name查询学生
    List<Users> getbynamegood(
            @Param("columnName")
            String columnName,
            @Param("columnValue")
            String columnValue
    );

    //添加学生
    int insert(Users u);

    //删除学生
    int delete(Integer id);

    //更新
    int update(Users users);
}
