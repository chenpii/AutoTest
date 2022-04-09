package com.course.testng.mytestdemo.api;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-04-08 22:21
 */
public class Order {


    public static String Order(String token) {
        //模拟接口返回
        if ("10000".equals(token)) {

            return "aabbcc123";
        }
        return "下单失败";
    }

    public static String CancelOrder(String orderID) {
        System.out.println("取消成功");
        return orderID;

    }


}
