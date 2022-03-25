package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * @author chenpi
 * @create 2022-03-24 17:10
 */
public class SutieConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite运行");
    }
	
	@AfterSuite
    public void afterSuite(){
        System.out.println("after suite运行");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
}
