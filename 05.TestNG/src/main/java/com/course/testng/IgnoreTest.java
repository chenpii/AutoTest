package com.course.testng;

import org.testng.annotations.Test;

/**
 * 忽略测试
 *
 * @author chenpi
 * @create 2022-03-26 9:55
 */
public class IgnoreTest {

    @Test
    public void ignore1() {
        System.out.println("ignore1 执行");
    }

    @Test(enabled = false)
    public void ignore2() {
        System.out.println("ignore2 执行");
    }

    @Test(enabled = true)
    public void ignore3() {
        System.out.println("ignore3 执行");
    }
}
