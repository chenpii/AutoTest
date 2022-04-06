package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenpi
 * @create 2022-04-06 16:08
 */
@RestController
@Api(value = "/", description = "全部的POST方法")
@RequestMapping(value = "/v1")
public class MyPostMethod {

    //保存Cookies
    private static Cookie cookie;

    //用户登录成功获取到Cookies，然后再访问其他接口获取列表

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取Cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String passWord) {

        if ("root".equals(userName) && "310012".equals(passWord)) {

            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "登录成功，获取到Cookies";
        }
        throw new RuntimeException("用户密码错误，登录失败！");
    }

@RequestMapping(value = "/getUser")
    public User getUsers() {
        User user = new User();
        return user;
    }
}
