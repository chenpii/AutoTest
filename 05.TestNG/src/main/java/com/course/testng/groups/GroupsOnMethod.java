package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 10:00
 */
public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1() {
        System.out.println("服务端组测试方法1");
    }

    @Test(groups = "server")
    public void test2() {
        System.out.println("服务端组测试方法2");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("客户端组测试方法3");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("客户端组测试方法4");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("服务端组之前运行");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("服务端组之后运行");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("客户端组之前运行");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient() {
        System.out.println("客户端组之后运行");
    }
}
