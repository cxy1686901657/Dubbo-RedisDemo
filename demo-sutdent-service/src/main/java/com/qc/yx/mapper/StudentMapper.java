package com.qc.yx.mapper;

import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAll();

    Student getStudentById(String id);

    List<Student> getStudentListByStudentIdList(@Param(value = "ids") List<String> ids);
}
