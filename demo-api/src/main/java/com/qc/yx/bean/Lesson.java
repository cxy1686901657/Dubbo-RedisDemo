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
 * @model demo-api
 * @project Dubbo-RedisDemo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "课程",description = "课程信息")
public class Lesson implements Serializable {
    @ApiModelProperty(name = "lesson_id",value = "课程id",dataType = "String",required = true,example = "131213")
    private String id;
    @ApiModelProperty(name = "lesson_name",value = "课程name",dataType = "String",required = true,example = "131213")
    private String name;
    @ApiModelProperty(name = "lesson_url",value = "课程url",dataType = "String",required = true,example = "131213")
    private String url;
    @ApiModelProperty(name = "lesson_password",value = "课程url_password",dataType = "String",required = true,example = "131213")
    private String password;
    @ApiModelProperty(name = "lesson_number",value = "课程number",dataType = "Integer",required = true,example = "131213")
    private Integer number;
    @ApiModelProperty(name = "lesson_teacher",value = "课程teacher",dataType = "String",required = true,example = "131213")
    private String teacher;
}
