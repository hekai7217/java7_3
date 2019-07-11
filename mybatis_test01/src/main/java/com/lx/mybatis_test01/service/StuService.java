package com.lx.mybatis_test01.service;

import com.lx.mybatis_test01.bean.Student;
import com.lx.mybatis_test01.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuService {

    @Autowired
    private StuMapper stuMapper;

    public List<Student> queryStu(){

        return  stuMapper.queryStus();
    }
}
