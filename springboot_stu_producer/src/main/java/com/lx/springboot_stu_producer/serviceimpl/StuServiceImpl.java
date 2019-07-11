package com.lx.springboot_stu_producer.serviceimpl;

import java.util.List;

import com.lx.springboot_stu_producer.mapper.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.lx.bean.Student;
import com.lx.service.StuService;

@Service  // 通过 dubbo 发布服务
@Component
public class StuServiceImpl implements StuService {

	// jms 模板
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private StuMapper stuMapper;

	@Override
	public List<Student> queryStus() {
		return stuMapper.queryStus();
	}

	@Override
	public int delStu(int id) {

		int delStu = stuMapper.delStu(id);

		if (delStu > 0) {
			//发送消息 数据库 数据 有变动 缓存 要清下
			jmsTemplate.convertAndSend("springboot_queue","del");
		}
		return delStu;
	}

}
