package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试
 * 方式一：
 * 在xml中以<parameter name="XXX" value="XXX"/>的形式提供测试数据
 *
 * @author chenpi
 * @create 2022-03-26 14:22
 */
public class ParameterTest {

    @Test
    @Parameters({"name", "age"})
    public void paramTest1(String name, int age) {
        System.out.println("name=" + name + ",age=" + age);

    }
}
