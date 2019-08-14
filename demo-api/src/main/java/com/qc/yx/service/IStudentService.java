package com.qc.yx.service;

import com.github.pagehelper.PageInfo;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.Student;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model api
 * @project Dubbo-RedisDemo
 */

public interface IStudentService {
    PageInfo<Student> getAll(int pageNum, int pageSize);

    Student getStudentById(String id);

    List<Student> getStudentByName(String name);

    void updateStudnet(Student student);

    void deleteStudentById(String id);

    void insertStudent(Student student);

    List<Lesson> getLessonByStudentId(Integer id);

    List<Student> getStudentListByStudentIdList(List<String> ids);
}
