package com.course.server;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * 一个需要携带参数才能访问的get请求
     * 方式一
     * ----url:key=value&&key=value
     * <p>
     *
     * 模拟获取商品列表
     */

    /**
     * @param start 起始位置
     * @param end   结束位置
     * @return 商品列表
     */
    @RequestMapping(value = "/getWithParam", method = RequestMethod.GET)
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("鞋", 400);
        map.put("干脆面", 1);
        map.put("衬衫", 300);

        return map;
    }

    /**
     * 一个需要携带参数才能访问的get请求
     * 方式二
     * ----url:ip:port/getWithParam/10/20
     */
    @RequestMapping(value = "getWithParam/{start}/{end}", method = RequestMethod.GET)
    public Map<String, Integer> getLists(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("鞋", 400);
        map.put("干脆面", 1);
        map.put("衬衫", 300);

        return map;
    }

}
