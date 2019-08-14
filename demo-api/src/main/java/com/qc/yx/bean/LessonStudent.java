package com.qc.yx.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "学生课程关联表",description = "学生课程关联表")
public class LessonStudent implements Serializable {
    @ApiModelProperty(name = "id",value = "id",dataType = "Integer",required = true,example = "131213")
    private Integer id;
    @ApiModelProperty(name = "lesson_id",value = "lesson_id",dataType = "String",required = true,example = "131213")
    private String lessonId;
    @ApiModelProperty(name = "student_id",value = "student_id",dataType = "String",required = true,example = "131213")
    private String studentId;
}
