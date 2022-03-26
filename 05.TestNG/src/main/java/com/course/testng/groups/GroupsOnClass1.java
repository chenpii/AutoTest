package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 10:32
 */
@Test(groups = "stu")
public class GroupsOnClass1 {

    public void stu1() {
        System.out.println("GroupsOnClass1中的stu111");
    }

    public void stu2() {
        System.out.println("GroupsOnClass1中的stu222");
    }
}
