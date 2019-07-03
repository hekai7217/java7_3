package com.lx.springboot_ssm.service;

import com.github.pagehelper.PageHelper;
import com.lx.springboot_ssm.bean.User;
import com.lx.springboot_ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(int id){
        return userMapper.queryUserById(id);
    }

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public List<User> queryLimit(int pageNo,int pageSize){

        //设置 第几页 和  每页的大小
        PageHelper.startPage(pageNo,pageSize);

        return userMapper.queryAll();
    }
}
