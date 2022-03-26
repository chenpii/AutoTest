package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author chenpi
 * @create 2022-03-26 10:32
 */
@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1() {
        System.out.println("GroupsOnClass2中的stu111");
    }

    public void stu2() {
        System.out.println("GroupsOnClass2中的stu222");
    }
}
