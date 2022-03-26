package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 参数化测试
 *
 * @author chenpi
 * @Test(dataProvider = "nameAndAge") 指定参数来源
 * @DataProvider(name = "nameAndAge") 提供测试数据
 * @create 2022-03-26 14:41
 */
public class DataProviderTest {

    @Test(dataProvider = "nameAndAge")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + ",age=" + age);
    }

    @DataProvider(name = "nameAndAge")
    public Object[][] prociderData() {
        Object[][] dataArr = new Object[][]{
                {"Tom", 23},
                {"Jack", 25},
                {"Ross", 27}
        };
        return dataArr;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name, int age) {
        System.out.println("test1方法：name=" + name + ",age=" + age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age) {
        System.out.println("test2方法：name=" + name + ",age=" + age);

    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        System.out.println("methodDataTest");
        Object[][] dataArr = null;
        if (method.getName().equals("test1")) {
            dataArr = new Object[][]{
                    {"Tom", 21},
                    {"Jack", 25}
            };
        }

        if (method.getName().equals("test2")) {
            dataArr = new Object[][]{
                    {"Ross", 28},
                    {"Rachel", 29}
            };

        }

        return dataArr;
    }
}
