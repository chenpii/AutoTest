package com.course.testng.mytestdemo.mycases;

import com.course.testng.mytestdemo.api.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-04-08 22:40
 */
public class testLogin {

    @Test
    public void LoginSuccess() {
        String s = Login.login("root", "310012");
        Assert.assertEquals(s, "10000");
    }

    @Test
    public void LoginFailed() {
        String s = Login.login("root", "310012");
        Assert.assertEquals(s, "登录失败");
    }
}
