package com.course.testng.mytestdemo.mycases;

import com.course.testng.mytestdemo.api.Login;
import com.course.testng.mytestdemo.api.Order;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

/**
 * @author chenpi
 * @create 2022-04-08 22:45
 */
public class testOrder {
    @BeforeClass
    public void login() {
        System.out.println("登录成功~~~~~~~~");
    }

    @Test
    public void OrderSuccess() {
        String s = Login.login("root", "310012");
        Assert.assertEquals(s, "10000");
        String orderId = Order.Order(s);
        Assert.assertEquals(orderId, "aabbcc123");
    }

    @Test
    public void OrderFailed() {
        String s = Login.login("root", "310012");
        Assert.assertEquals(s, "10000");
        String orderId = Order.Order(s + "0");
        Assert.assertEquals(orderId, "下单失败");
    }
}
