package com.lx.springboot_stu_producer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lx.bean.Student;

@Mapper
public interface StuMapper {

	/**
	 * 查询 所有的学生
	 * @return
	 */
	public List<Student> queryStus();
	
	/**
	 * 删除学生 
	 * @param id
	 * @return
	 */
	public int delStu(int id);
	
}
