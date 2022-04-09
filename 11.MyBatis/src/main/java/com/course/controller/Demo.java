package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenpi
 * @create 2022-04-07 16:31
 */

@RestController
@Api(value = "v1", description = "第一个版本的demo")
@RequestMapping(value = "v1")
public class Demo {

    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;


    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户数量", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    public int addUser(@RequestBody User user) {
        return template.insert("addUser", user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户", httpMethod = "POST")
    public int updateUser(@RequestBody User user) {
        return template.update("updateUser", user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ApiOperation(value = "删除用户", httpMethod = "POST")
    public int deleteUser(@RequestParam int id) {
        return template.delete("deleteUser", id);
    }
}
