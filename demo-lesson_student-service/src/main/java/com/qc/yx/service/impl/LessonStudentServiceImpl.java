package com.qc.yx.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.LessonStudent;
import com.qc.yx.bean.Student;
import com.qc.yx.mapper.LessonStudentMapper;
import com.qc.yx.service.ILessonService;
import com.qc.yx.service.ILessonStudentService;
import com.qc.yx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model 设计原则
 * @project Dubbo-RedisDemo
 */
@Service
@Component
public class LessonStudentServiceImpl implements ILessonStudentService {
    @Autowired
    LessonStudentMapper lessonStudentMapper;
    @Reference
    IStudentService studentService;
    @Reference
    ILessonService lessonService;


    @Override
    public List<Student> getStudentsByLessonId(String id) {
        List<String> studentIds=lessonStudentMapper.getStudentIdListByLessonId(id);
        List<Student> studentListByStudentIdList = studentService.getStudentListByStudentIdList(studentIds);
        return studentListByStudentIdList;
    }

    @Override
    public List<Lesson> getLessonsByStudentId(String id) {
        List<String> lessonIdListByStudentId = lessonStudentMapper.getLessonIdListByStudentId(id);
        List<Lesson> lessonListByLessonIdList = lessonService.getLessonListByLessonIdList(lessonIdListByStudentId);
        return lessonListByLessonIdList;
    }

    @Override
    public void insertStudentSubLesson(LessonStudent lessonStudent) {
        lessonStudentMapper.deleteStudentSubLesson(lessonStudent.getStudentId(), lessonStudent.getLessonId());
        lessonStudentMapper.insertSelective(lessonStudent);
    }

    @Override
    public void deleteStudentSubLesson(String studentId, String lessonId) {
        lessonStudentMapper.deleteStudentSubLesson(studentId,lessonId);
    }

}
