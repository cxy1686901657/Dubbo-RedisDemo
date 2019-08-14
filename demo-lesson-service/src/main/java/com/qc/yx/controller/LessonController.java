package com.qc.yx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.Student;
import com.qc.yx.common.ServerResponse;
import com.qc.yx.enums.ExceptionEnum;
import com.qc.yx.service.ILessonService;
import com.qc.yx.service.ILessonStudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/10
 * @description
 * @model   lesson
 * @project Dubbo-RedisDemo
 */
@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    ILessonService lessonService;

//    @Reference
//    IStudentService studentService;

    @Reference
    ILessonStudentService lessonStudentService;


    @GetMapping("/list")
    @ApiOperation(value = "分页返回课程信息", notes = "分页查按照所有课程")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", paramType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面显示条数")}
    )
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse getAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                 @RequestParam(value = "name",required = false) String name) {
        if(StringUtils.isEmpty(name)){
            return ServerResponse.createBySuccess(lessonService.getAll(pageNum, pageSize));
        }
        return ServerResponse.createBySuccess(lessonService.getAllByLessonName(pageNum, pageSize,name));
    }
    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据id获取lesson", notes = "根据id获取lesson")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse getLessonById(@PathVariable(name = "id") String id){
        Lesson lessonById = lessonService.getLessonById(id);
        if (StringUtils.isEmpty(lessonById)){
            return ServerResponse.createBySuccessMessage("no lesson");
        }
        return ServerResponse.createBySuccess(lessonById);
    }
    @ApiOperation(value = "新增课程", notes = "新增课程")
    @PostMapping("/insert")
    @ApiImplicitParam(name = "lesson", value = "新增课程", paramType = "Lesson")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse insertStudent(Lesson lesson){
        if(lesson==null){
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        lessonService.insertLesson(lesson);
        return ServerResponse.createBySuccess("添加成功");
    }
    @ApiOperation(value = "删除课程", notes = "删除课程")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "id", value = "删除课程id", paramType = "String")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse delLesson(@RequestParam(value = "id") String id){
        if(StringUtils.isEmpty(id)){
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        lessonService.deleteLessonById(id);
        return ServerResponse.createBySuccessMessage("del成功");
    }
    @ApiOperation(value = "更新课程", notes = "更新课程")
    @PostMapping("/update")
    @ApiImplicitParam(name = "lesson", value = "更新课程", paramType = "Lesson")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse updateStudent(Lesson lesson){
        if(StringUtils.isEmpty(lesson.getName())){
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        lessonService.updateLesson(lesson);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @ApiOperation(value = "获取课程所有学生", notes = "获取课程所有学生")
    @GetMapping("/get")
    @ApiImplicitParam(name = "lesson_id", value = "lesson_id", paramType = "String")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "error")
    })
    public ServerResponse getStudentsByLessonId(@RequestParam(value = "id") String id){
        List<Student> studentsByLessonId = lessonStudentService.getStudentsByLessonId(id);
        return ServerResponse.createBySuccess(studentsByLessonId);
    }
}
