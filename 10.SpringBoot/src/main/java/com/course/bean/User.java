package com.course.bean;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * 用户类
 *
 * @author chenpi
 * @create 2022-04-06 16:49
 */
@Data
public class User {

    private String name;
    private int age;
    private String sex;

}
