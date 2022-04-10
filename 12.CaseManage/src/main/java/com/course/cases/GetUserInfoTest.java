package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-04-10 18:04
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginSuccess", description = "获取userId为1的用户信息")
    public void getUserInfoByUserId() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase", 1);
        System.out.println(getUserInfoCase);
        System.out.println(TestConfig.getUserInfoUrl);
    }
}
