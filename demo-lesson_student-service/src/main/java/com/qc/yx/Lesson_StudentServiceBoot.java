package com.qc.yx;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author qc
 * @date 2019/8/12
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@EnableDubbo
@MapperScan(basePackages = "com.qc.yx.mapper")
@SpringBootApplication
public class Lesson_StudentServiceBoot {
    public static void main(String[] args){
        SpringApplication.run(Lesson_StudentServiceBoot.class, args);
    }
}
