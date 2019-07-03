package com.lx.springboot_ssm;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.springboot_ssm.bean.User;
import com.lx.springboot_ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSsmApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void demo01(){

        User user = userService.queryUserById(1);

        System.out.println(user);

    }

    @Test
    public void demo02(){

        userService.queryAll().forEach(e-> System.out.println(e));
    }

    /**
     *    分页的操作:
     *         mysql 中的 limit 的使用
     *
     *     jdbc中 自己如何实现分页 :
     *          ps + sql （limiet start ）
     *
     *     mvc中 我都是在 service 层实现分页
     *
     *     mybatis 中分页 也是用的 limit
     *
     *     springboot 分也插件的使用
     *             service 设置     PageHelper.startPage(pageNo,pageSize);
     */
    @Test
    public void demo03(){

        //分页查询
        // pageNo   第几页
        // pageSize 每页的大小
        List<User> users = userService.queryLimit(2,4);
        users.forEach(e-> System.out.println(e.getUsername()));

    }
}
