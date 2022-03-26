package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试
 * 方式二：
 * 通过xml
 *
 * @author chenpi
 * @create 2022-03-26 15:26
 */
public class MultiThreadOnXml {

    @Test
    public void test1() {
        System.out.printf("Thread ID : %s%n ", Thread.currentThread().getId());
    }

    @Test
    public void test2() {
        System.out.printf("Thread ID : %s%n ", Thread.currentThread().getId());
    }

    @Test
    public void test3() {
        System.out.printf("Thread ID : %s%n ", Thread.currentThread().getId());
    }
}
