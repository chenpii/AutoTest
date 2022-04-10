package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 登录接口测试
 *
 * @author chenpi
 * @create 2022-04-10 12:40
 */
public class LoginTest {

    @BeforeTest(groups = "loginSuccess", description = "测试前准备工作")
    public void beforeTest() {

        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.httpClient = new DefaultHttpClient();

    }

    @Test(groups = "loginSuccess", description = "用户登录成功接口测试")
    public void login_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //取id为1的登录接口测试数据
        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);
        System.out.println(loginCase);
        System.out.println(TestConfig.loginUrl);
    }

    @Test(groups = "loginFailed", description = "用户登录失败接口测试")
    public void login_Failed() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //取id为2的登录接口测试数据
        com.course.model.LoginCase loginCase = sqlSession.selectOne("loginCase", 2);
        System.out.println(loginCase);
        System.out.println(TestConfig.loginUrl);
    }

}
