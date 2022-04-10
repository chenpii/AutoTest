package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 新增用户接口测试
 *
 * @author chenpi
 * @create 2022-04-10 17:55
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginSuccess", description = "添加用户接口测试")
    public void addUser_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //获取id为1的测试数据
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase", 1);
        System.out.println(addUserCase);
        System.out.println(TestConfig.addUserUrl);

    }
}
