package com.lx.mybatis_test01;

import com.lx.mybatis_test01.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@MapperScan(basePackages = "com.lx")
public class MybatisTest01ApplicationTests {

    @Autowired
    private StuService stuService;

    @Test
    public void contextLoads() {
        stuService.queryStu().forEach(e-> System.out.println(e));
    }

}
