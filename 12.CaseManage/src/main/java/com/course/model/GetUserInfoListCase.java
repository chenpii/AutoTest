package com.course.model;

import lombok.Data;

/**
 * 获取用户信息列表-测试用例表
 *
 * @author chenpi
 * @create 2022-04-09 14:23
 */
@Data
public class GetUserInfoListCase {
    private String userName;
    private int age;
    private int sex;
    private String expected;
}
