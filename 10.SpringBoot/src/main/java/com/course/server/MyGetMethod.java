package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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

    /**
     * 要求客户端携带Cookies访问
     */
    @RequestMapping(value = "/getWithCookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "cookies为空，需携带Cookies信息";
        }

        for (Cookie c : cookies
        ) {
            if (c.getName().equals("login") && c.getValue().equals("true")) {
                return "这是一个需要携带Cookies信息才能访问的get接口";
            }

        }

        return "未携带Cookies信息";

    }
}
