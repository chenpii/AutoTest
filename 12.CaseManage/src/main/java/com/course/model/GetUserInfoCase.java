package com.course.model;

import lombok.Data;

/**
 * 获取用户信息-测试用例表
 *
 * @author chenpi
 * @create 2022-04-09 14:22
 */
@Data
public class GetUserInfoCase {

    private int userId;
    private String  expected;
}
