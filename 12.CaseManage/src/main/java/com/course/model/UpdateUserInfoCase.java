package com.course.model;

import lombok.Data;

/**
 * 更新/删除用户-测试用例表
 *
 * @author chenpi
 * @create 2022-04-09 14:27
 */
@Data
public class UpdateUserInfoCase {
    private int userId;
    private String userName;
    private int sex;
    private int age;
    private int permission;
    private int isDelete;
    private String expected;
}
