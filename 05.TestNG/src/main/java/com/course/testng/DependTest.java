package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 14:13
 */
public class DependTest {

    @Test
    public void test1() {
        System.out.println("test1 run ");
        throw new RuntimeException("异常");
    }

    /**
     * 依赖测试方法若失败，此测试方法会跳过
     */
    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("test2 run ");
    }

}
