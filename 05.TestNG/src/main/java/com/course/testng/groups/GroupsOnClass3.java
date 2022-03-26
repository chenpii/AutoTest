package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 10:32
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void tea1() {
        System.out.println("GroupsOnClass3中的tea111");
    }

    public void tea2() {
        System.out.println("GroupsOnClass3中的tea222");
    }
}
