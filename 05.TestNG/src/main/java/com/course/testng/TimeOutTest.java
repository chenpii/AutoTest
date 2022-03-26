package com.course.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 *
 * @author chenpi
 * @create 2022-03-26 16:01
 */
public class TimeOutTest {

    //设置超时时间为3000毫秒
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(4000);
    }
}
