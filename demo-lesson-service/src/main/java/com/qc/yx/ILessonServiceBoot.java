package com.qc.yx;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qc
 * @date 2019/8/10
 * @description
 * @model
 * @project Dubbo-RedisDemo
 */
@EnableDubbo
@MapperScan(basePackages = "com.qc.yx.mapper")
@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class ILessonServiceBoot {
    public static void main(String[] args){
        SpringApplication.run(ILessonServiceBoot.class, args);
    }
}
