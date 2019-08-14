package com.qc.yx.service;

import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.LessonStudent;
import com.qc.yx.bean.Student;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
public  interface ILessonStudentService {
    List<Student> getStudentsByLessonId(String id);

    List<Lesson> getLessonsByStudentId(String id);

    void insertStudentSubLesson(LessonStudent lessonStudent);

    void deleteStudentSubLesson(String studentId,String lessonId);
}
