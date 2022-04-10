package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoListCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-04-10 18:09
 */
public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginSuccess", description = "获取性别为男的用户信息列表")
    public void getUserInfoListBySex() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoListCase getUserInfoCase = sqlSession.selectOne("getUserInfoListCase", 1);
        System.out.println(getUserInfoCase);
        System.out.println(TestConfig.getUserListUrl);
    }
}
