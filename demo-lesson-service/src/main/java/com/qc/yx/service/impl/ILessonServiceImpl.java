package com.qc.yx.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.Student;
import com.qc.yx.enums.ExceptionEnum;
import com.qc.yx.exception.GlobalException;
import com.qc.yx.mapper.LessonMapper;
import com.qc.yx.service.ILessonService;
import com.qc.yx.utils.RandomPrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@Service
@Component
public class ILessonServiceImpl implements ILessonService {
    @Autowired
    LessonMapper lessonMapper;
    @Override
    @Cacheable(value = "lessons")
    public PageInfo<Lesson> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lesson> lessonList = lessonMapper.getAll();
        PageInfo<Lesson> studentPageInfo = new PageInfo<>(lessonList);
        return studentPageInfo;
    }

    @Override
    public PageInfo<Lesson> getAllByLessonName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Lesson> lessonList = lessonMapper.getAllByLessonName(name);
        PageInfo<Lesson> studentPageInfo = new PageInfo<>(lessonList);
        return studentPageInfo;
    }

    @Override
    //todo
    public Lesson getLessonById(String id) {
        lessonMapper.getLessonById(id);
        return null;
    }

    @Override
    public void updateLesson(Lesson lesson) {
        if(StringUtils.isEmpty(lesson.getId())){
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        lessonMapper.updateByPrimaryKey(lesson);
    }

    @Override
    public void deleteLessonById(String id) {
        if(StringUtils.isEmpty(id)){
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        lessonMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertLesson(Lesson lesson) {
        if(StringUtils.isEmpty(lesson.getName())){
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        lesson.setId(RandomPrimaryKeyUtil.generateKey());
        lessonMapper.insertSelective(lesson);
    }

    @Override
    public List<Lesson> getLessonListByLessonIdList(List<String> ids) {

        if(ids==null){
            throw new GlobalException(ExceptionEnum.PARAM_ERROR);
        }
        List<Lesson> lessonListByLessonIdList = lessonMapper.getLessonListByLessonIdList(ids);
        return lessonListByLessonIdList;
    }
}
