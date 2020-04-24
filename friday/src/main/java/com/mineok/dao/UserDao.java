package com.mineok.dao;

import com.mineok.entities.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from sys_user t where t.username = #{username}")
    SysUser getUser(String username);

    // 分页查询
    @Select("select * from sys_user t order by t.id limit #{offset}, #{limit}")
    List<SysUser> getAllUsersByPage(@Param("offset") Integer offset,
                                    @Param("limit") Integer limit);

    @Select("select count(*) from sys_user")
    Long countAllUsers();
}
