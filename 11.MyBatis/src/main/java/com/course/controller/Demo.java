package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpi
 * @create 2022-04-07 16:31
 */

@RestController
@Api(value = "v1", description = "第一个版本的demo")
@RequestMapping(value = "v1")
public class Demo {

    //首先获取一个执行sql语句的对象
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数量", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");

    }
}
