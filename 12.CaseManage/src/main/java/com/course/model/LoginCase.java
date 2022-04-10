package com.course.model;

import lombok.Data;

/**
 * 登录测试用例表
 *
 * @author chenpi
 * @create 2022-04-09 14:25
 */

@Data
public class LoginCase {
    private String userName;
    private String password;
    private String expected;

}
