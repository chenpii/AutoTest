package com.course.model;

import lombok.Data;

/**
 * 新增用户-测试用例表
 *
 * @author chenpi
 * @create 2022-04-09 14:19
 */
@Data
public class AddUserCase {
    private String userName;
    private String password;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;
    private String expeceted;
}
