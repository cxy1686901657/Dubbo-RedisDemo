package com.qc.yx.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.yx.bean.Lesson;
import com.qc.yx.bean.LessonStudent;
import com.qc.yx.bean.Student;
import com.qc.yx.common.ServerResponse;
import com.qc.yx.enums.ExceptionEnum;
import com.qc.yx.service.ILessonStudentService;
import com.qc.yx.service.IStudentService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qc
 * @date 2019/8/10
 * @description
 * @model demo-student-service
 * @project Dubbo-RedisDemo
 */
@RestController
@RequestMapping("/student")
@Api(value = "学生接口", description = "学生信息")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @Reference
    ILessonStudentService lessonStudentService;

    @GetMapping("/unsub")
    @ApiOperation(value = "学生取消订阅课程", notes = "学生取消订阅课程")
    @ApiImplicitParams({@ApiImplicitParam(name = "sid", value = "学生id", paramType = "String"),
            @ApiImplicitParam(name = "lid", value = "课程")}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })

    public ServerResponse unSubScribe(@RequestParam(name = "sid") String studentId,
                                      @RequestParam(name = "lid") String lessonId) {
        lessonStudentService.deleteStudentSubLesson(studentId, lessonId);
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/sub")
    @ApiOperation(value = "学生订阅课程", notes = "学生订阅课程")
    @ApiImplicitParams({@ApiImplicitParam(name = "sid", value = "学生id", paramType = "String"),
            @ApiImplicitParam(name = "lid", value = "课程")}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    /**
     * @param lesson
     * @return com.qc.yx.common.ServerResponse
     * @author qc
     * @description 目前未作登录或者往session/cookie。。
     * @date 2019/8/13
     */
    public ServerResponse subScribe(@RequestParam(name = "sid") String studentId,
                                    @RequestParam(name = "lid") String lessonId) {
        LessonStudent.LessonStudentBuilder lessonStudentBuilder = LessonStudent.builder().studentId(studentId).lessonId(lessonId);
        lessonStudentService.insertStudentSubLesson(lessonStudentBuilder.build());
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页返回学生信息", notes = "分页查按照所有学生")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", paramType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面显示条数")}
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse getAll(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return ServerResponse.createBySuccess(iStudentService.getAll(pageNum, pageSize));
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据id获取student", notes = "根据id获取student")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse getStudentById(@PathVariable(name = "id") String id) {
        Student studentById = iStudentService.getStudentById(id);
        if (StringUtils.isEmpty(studentById)) {
            return ServerResponse.createBySuccessMessage("no student");
        }
        return ServerResponse.createBySuccess(studentById);
    }

    @ApiOperation(value = "新增学生", notes = "新增学生")
    @PostMapping("/insert")
    @ApiImplicitParam(name = "student", value = "新增的学生", paramType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse insertStudent(Student student) {
        if (student == null) {
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        iStudentService.insertStudent(student);
        return ServerResponse.createBySuccess("添加成功");
    }

    @ApiOperation(value = "删除学生", notes = "删除学生")
    @PostMapping("/delete")
    @ApiImplicitParam(name = "id", value = "删除学生id", paramType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse delStudent(@RequestParam(value = "id") String id) {
        if (StringUtils.isEmpty(id)) {
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        iStudentService.deleteStudentById(id);
        return ServerResponse.createBySuccessMessage("del成功");
    }

    @ApiOperation(value = "更新学生", notes = "更新学生")
    @PostMapping("/update")
    @ApiImplicitParam(name = "student", value = "更新学生", paramType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse updateStudent(Student student) {
        if (StringUtils.isEmpty(student.getName())) {
            return ServerResponse.createByErrorCodeMessage(ExceptionEnum.PARAM_ERROR.getCode()
                    , ExceptionEnum.PARAM_ERROR.getMsg());
        }
        iStudentService.updateStudnet(student);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @ApiOperation(value = "学生所拥有课程", notes = "学生所拥有课程")
    @GetMapping("/lessons/{id}")
    @ApiImplicitParam(name = "id", value = "id", paramType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    public ServerResponse lessons(@PathVariable(name = "id") String id) {
        List<Lesson> lessonsByStudentId = lessonStudentService.getLessonsByStudentId(id);
        return ServerResponse.createBySuccess(lessonsByStudentId);
    }

}
