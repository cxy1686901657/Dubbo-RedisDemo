package com.qc.yx.controller;

import com.qc.yx.Lesson_StudentServiceBoot;
import com.qc.yx.bean.Student;
import com.qc.yx.common.ServerResponse;
import com.qc.yx.service.ILessonStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/13
 * @description
 * @model test
 * @project Dubbo-RedisDemo
 */
@RequestMapping("/ls")
@RestController
public class LessonStudentController {
    @Autowired
    ILessonStudentService lessonStudentService;
    /*
    *   T    E   S   T
    *
    * */
    @GetMapping("/sid/{id}")
    public ServerResponse getStudentsByLessonId(@PathVariable(name = "id")String id){
        List<Student> studentsByLessonId = lessonStudentService.getStudentsByLessonId(id);
        return ServerResponse.createBySuccess(studentsByLessonId);
    }
}
