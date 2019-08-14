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
 * @date 2019/8/9
 * @description
 * @model api
 * @project Dubbo-RedisDemo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生",description = "学生信息")
public class Student implements Serializable {
    @ApiModelProperty(name = "student_id",value = "student_id",dataType = "String",required = true,example = "131213")
    private String id;
    @ApiModelProperty(name = "student_name",value = "student_name",dataType = "String",required = true,example = "131213")
    private String name;
    @ApiModelProperty(name = "student_email",value = "student_email",dataType = "String",required = true,example = "131213")
    private String email;
    @ApiModelProperty(name = "student_sex",value = "student_sex",dataType = "String",required = true,example = "1")
    private Integer sex;
    @ApiModelProperty(name = "student_password",value = "student_password",dataType = "String",required = true,example = "1")
    private String password;
}
