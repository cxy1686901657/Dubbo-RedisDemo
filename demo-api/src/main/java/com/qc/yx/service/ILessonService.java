package com.qc.yx.service;

import com.github.pagehelper.PageInfo;
import com.qc.yx.bean.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model api
 * @project Dubbo-RedisDemo
 */

public interface ILessonService {
    PageInfo<Lesson> getAll(int pageNum, int pageSize);

    PageInfo<Lesson> getAllByLessonName(int pageNum, int pageSize,String name);

    Lesson getLessonById(String id);

    void updateLesson(Lesson lesson);

    void deleteLessonById(String id);

    void insertLesson(Lesson lesson);

    List<Lesson> getLessonListByLessonIdList(@Param(value = "ids") List<String> ids);
}
