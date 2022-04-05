package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * RestController:告诉ComponentScan，我是需要被你扫描的类
 * RequestMapping:
 * ---value:接口访问的路径。
 * ---method:接口访问的方法。get、post
 *
 * @author chenpi
 * @create 2022-04-05 10:18
 */
@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest 装请求信息的类
        //HttpServletResponse 装响应信息的类

        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得Cookies成功";
    }
}
