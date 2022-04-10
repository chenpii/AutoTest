package com.course.model;

import lombok.Data;

/**
 * 用户表
 * @author chenpi
 * @create 2022-04-09 14:14
 */
@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private int age;
    private int sex;
    private int permission;
    private int isDelete;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", permission=" + permission +
                ", isDelete=" + isDelete +
                '}';
    }
}
