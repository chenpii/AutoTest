package com.course.testng;

import org.testng.annotations.*;

/**
 * @author chenpi
 * @create 2022-03-24 16:55
 */
public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("测试方法执行之前");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("测试方法执行之后");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("测试类执行之前");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("测试类执行之后");
    }
}
