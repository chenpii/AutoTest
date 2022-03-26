package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试
 * 方式一：
 * 通过注解实现多线程
 *
 * @author chenpi
 * @create 2022-03-26 15:22
 */
public class MultiThreadOnAnnotion {

    //指定线程池
    @Test(invocationCount = 10, threadPoolSize = 3)
    public void test1() {
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
