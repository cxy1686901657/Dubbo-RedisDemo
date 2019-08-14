package com.qc.yx.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.Student;
import com.qc.yx.enums.ExceptionEnum;
import com.qc.yx.exception.GlobalException;
import com.qc.yx.mapper.StudentMapper;
import com.qc.yx.service.IStudentService;
import com.qc.yx.utils.RandomPrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@Service
@Component
public class IStudentServiceImpl implements IStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    @Cacheable(cacheNames = "students")
    public PageInfo<Student> getAll(int pageNum, int pageSize) {
        System.out.println("1111");
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentMapper.getAll();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList);
        return studentPageInfo;
    }


    @Override
    public Student getStudentById(String id) {
        if (!StringUtils.isEmpty(id)) {
            Student studentById = studentMapper.getStudentById(id);
            return studentById;
        }
        //TODO
        return new Student();
    }

    @Override
    //TODO
    public List<Student> getStudentByName(String name) {
        return null;
    }

    @Override
    public void updateStudnet(Student student) {
        if (student == null) {
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public void deleteStudentById(String id) {
        if (!StringUtils.isEmpty(id)) {
            studentMapper.deleteByPrimaryKey(id);
        } else {
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
    }

    @Override
    public void insertStudent(Student student) {
        student.setId(RandomPrimaryKeyUtil.generateKey());
        if (!StringUtils.isEmpty(student.getId())) {
            Student queryStudent = studentMapper.selectByPrimaryKey(student.getId());
            if (!StringUtils.isEmpty(queryStudent)) {
                throw new GlobalException(ExceptionEnum.STUDENT_EXIST);
            } else {
                studentMapper.insertSelective(student);
            }
        }
    }

    @Override
    public List<Lesson> getLessonByStudentId(Integer id) {
        return null;
    }

    @Override
    public List<Student> getStudentListByStudentIdList(List<String> ids) {
        if(ids==null){
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        List<Student> studentListByStudentIdList = studentMapper.getStudentListByStudentIdList(ids);
        return studentListByStudentIdList;
    }
}
