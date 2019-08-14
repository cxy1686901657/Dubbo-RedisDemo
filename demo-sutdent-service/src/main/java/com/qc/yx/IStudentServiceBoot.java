package com.qc.yx;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model   student-service
 * @project Dubbo-RedisDemo
 */
@EnableCaching
@EnableDubbo
@MapperScan(basePackages = "com.qc.yx.mapper")
@SpringBootApplication
@EnableSwagger2
public class IStudentServiceBoot {
    public static void main(String[] args){
        SpringApplication.run(IStudentServiceBoot.class, args);
    }

}
