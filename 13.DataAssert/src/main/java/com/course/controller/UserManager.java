package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Objects;

/**
 * @author chenpi
 * @create 2022-04-11 15:37
 */
@Slf4j
@RestController
@Api(value = "v1", description = "用户管理系统")
@RequestMapping(value = "v1")
public class UserManager {
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口", httpMethod = "POST")
    public boolean login(HttpServletResponse response,
                         @RequestBody User user) {
        int i = template.selectOne("login", user);
        Cookie cookie = new Cookie("login", "true");
        log.info("查询到的用户是" + i);
        if (i == 1) {
            log.info("登录的用户是" + user.getUserName());
            response.addCookie(cookie);
            return true;
        } else {
            return false;
        }

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", httpMethod = "POST")
    public boolean addUser(HttpServletRequest request,
                           @RequestBody User user) {
        Boolean x = veryCookies(request);
        int result = 0;
        if (x) {
            result = template.insert("addUser", user);
        }
        if (result > 0) {
            log.info("新增的用户为" + user);
            return true;
        }
        return false;

    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息(列表)", httpMethod = "POST")
    public List<User> getUserInfoList(HttpServletRequest request,
                                      @RequestBody User user) {

        if (veryCookies(request)) {
            List<User> userList = template.selectList("getUserInfo", user);
            log.info("getUserInfo获取到的用户数量是" + userList.size());
            return userList;
        }
        return null;
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新/删除用户", httpMethod = "POST")
    public int updateUser(HttpServletRequest request,
                          @RequestBody User user) {
        int i = 0;
        if (veryCookies(request)) {
            i = template.update("updateUserInfo", user);
        }
        log.info("更新用户的数量为:" + i);
        return i;
    }

    private Boolean veryCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            log.info("Cookie为空！");
            return false;
        }
        for (Cookie c : cookies) {
            if (c.getName().equals("login") && c.getValue().equals("true")) {
                log.info("Cookie验证通过！");
                return true;
            }

        }
        return false;
    }

}
