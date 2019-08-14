package com.qc.yx.mapper;


import com.qc.yx.bean.Lesson;
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
public interface LessonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    Lesson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);

    List<Lesson> getAll();

    List<Lesson> getAllByLessonName(@Param(value = "name") String name);

    Lesson getLessonById(@Param(value = "id") String id);


    List<Lesson> getLessonListByLessonIdList(@Param(value = "ids")List<String> ids);
}
