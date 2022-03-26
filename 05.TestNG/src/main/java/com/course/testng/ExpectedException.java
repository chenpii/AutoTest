package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 11:02
 */
public class ExpectedException {
    /**
     * 什么时候用到异常测试？
     * 在期望某个结果为异常的时候。
     * 比如：传参不合法，程序抛出了异常，即预期结果就是异常
     */
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSucces() {
        System.out.println("成功的异常测试");
        throw new RuntimeException("自定义异常");
    }


}
