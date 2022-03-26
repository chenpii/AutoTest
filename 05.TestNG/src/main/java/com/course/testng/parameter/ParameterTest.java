package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
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
