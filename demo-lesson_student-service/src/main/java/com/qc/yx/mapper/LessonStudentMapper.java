package com.qc.yx.mapper;

import com.qc.yx.bean.LessonStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@Mapper
public interface LessonStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LessonStudent record);

    int insertSelective(LessonStudent record);

    LessonStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LessonStudent record);

    int updateByPrimaryKey(LessonStudent record);

    List<String> getStudentIdListByLessonId(String id);

    List<String> getLessonIdListByStudentId(String id);

    void deleteStudentSubLesson(@Param(value = "sid") String studentId, @Param(value = "lid") String lessonId);
}
