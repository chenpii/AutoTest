package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-28 10:53
 */
public class TestMethodsDemo {

    @Test
    public void test1() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test3() {
        Assert.assertEquals("abc", "abc");
    }

    @Test
    public void logDemo() {
        Reporter.log("自定义日志");
        throw new RuntimeException("自定义异常信息");
    }
}
