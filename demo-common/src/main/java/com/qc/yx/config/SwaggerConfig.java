package com.qc.yx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author qc
 * @date 2019/8/11
 * @description
 * @model 设计原则
 * @project Dubbo-RedisDemo
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)//文档类型：DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())//api信息
                .select()//构建api选择器
                .apis(RequestHandlerSelectors.basePackage("com.qc.yx.controller"))//配置为Controller层的路径
                .paths(PathSelectors.any())//api选择器选择包路径下任何api显示在文档中，根据需要配置所有还是用正则过滤
                .build();//创建文档
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo-Dubbo接口文档")
                .termsOfServiceUrl("。。。")
                .version("1.0")
                .build();
    }
}
