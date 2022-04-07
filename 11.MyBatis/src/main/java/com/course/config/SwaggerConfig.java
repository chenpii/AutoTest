package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * --Configuration 配置类
 * --EnableSwagger2 Swagger配置
 *
 * @author chenpi
 * @create 2022-04-06 15:35
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/") //配置访问路径
                .select()
                .paths(PathSelectors.regex("/.*"))//正则表达式 匹配 接口方法名,目前方法名没有统一的前缀，故用/.*
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")  //页面title
                .contact(new Contact("chenp", "", "641760512@qq.com")) //联系人
                .description("swagger接口文档") //描述
                .version("1.0.0")
                .build();

    }
}
