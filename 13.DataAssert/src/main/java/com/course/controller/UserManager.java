package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author chenpi
 * @create 2022-04-11 15:37
 */
@Log4j
@RestController
@Api(value = "v1", description = "用户管理系统")
@RequestMapping(value = "v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(HttpServletResponse response,
                         @RequestBody User user) {

        return true;
    }

}
