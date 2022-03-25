package com.course.testng;

import org.testng.annotations.*;

/**
 * @author chenpi
 * @create 2022-03-24 16:55
 */
public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1() {
        System.out.println("Test这是测试用例1");
    }

    @Test
    public void testCase2() {
        System.out.println("Test这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass这是在类运行之前运行的");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass这是在类运行之后运行的");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite这是在测试套件运行之前运行的");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite这是在测试套件运行之后运行的");
    }

}
