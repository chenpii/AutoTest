package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-04-10 18:12
 */
public class UpdateUserTest {
    @Test(dependsOnGroups = "loginSuccess", description = "更新用户信息")
    public void updateUser_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserCase = sqlSession.selectOne("updateUserCase", 1);
        System.out.println(updateUserCase);
        System.out.println(TestConfig.updateUserInfoUrl);

    }

    @Test(dependsOnGroups = "loginSuccess", description = "删除用户信息")
    public void deleteUser_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserCase = sqlSession.selectOne("updateUserCase", 2);
        System.out.println(updateUserCase);
        System.out.println(TestConfig.updateUserInfoUrl);
    }


}
