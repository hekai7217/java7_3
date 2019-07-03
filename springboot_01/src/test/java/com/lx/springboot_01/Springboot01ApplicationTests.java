package com.lx.springboot_01;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebAppConfiguration  // 配置 加载 webapplication 对象
@SpringBootTest   // spring boot的测试 和 spring的测试区别
                   // 1. RunWith 不一样           (SpirngJunt4Runner.class)  Contextconfition ("applicationContent.xml")
                   //  2. 添加了 新的注解  SpringBootTest
public class Springboot01ApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    // mvc 的测试 类型
    private MockMvc mockMvc;

    //mvc 初始化
    @Before
    public void init() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void put() throws Exception {

        // 执行mvc 的请求perform
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.put("/put")
                        .param("id", "44")
        ).andDo(
                        // 测试信息 控制台 打印
                        MockMvcResultHandlers.print()
                ).andReturn();

        String context = result.getResponse().getContentAsString();
        System.out.println("resutl:" + context);
    }

    @Test
    public void contextLoads() {
    }

}
