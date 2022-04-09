package com.course.testng.mytestdemo.api;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-04-08 22:19
 */
public class Login {

    //token值
    private static String token;

    public static String login(String username, String password) {
        System.out.println("username=" + username + ",password=" + password);

        //模拟接口返回
        if ("root".equals(username) && "310012".equals(password)) {
            System.out.println("登录成功");
            token = "10000";
            return token;

        }
        return "登录失败";
    }

}
