package com.lx.springboot_ssm.mapper;


import com.lx.springboot_ssm.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 通过 id 查询 user
     * @param id
     * @return
     */
    public User queryUserById(int id);

    /**
     * 查询所有的用户
     * @return
     */
    public List<User> queryAll();
}
