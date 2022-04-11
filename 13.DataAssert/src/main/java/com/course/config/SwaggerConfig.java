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
 * @author chenpi
 * @create 2022-04-11 15:32
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
                .title("UserManager service API")  //页面title
                .contact(new Contact("chenp", "", "641760512@qq.com")) //联系人
                .description("this is UserManager service API") //描述
                .version("1.0")
                .build();

    }
}
