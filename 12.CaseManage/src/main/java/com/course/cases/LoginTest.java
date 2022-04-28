package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
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
        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }

    @Test(groups = "loginSuccess", description = "用户登录成功接口测试")
    public void login_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //取id为1的登录接口测试数据
        LoginCase loginCase = sqlSession.selectOne("loginCase", 1);
        System.out.println(loginCase);
        System.out.println(TestConfig.loginUrl);

        //发请求，获取结果
        String result = getResult(loginCase);

        //验证返回结果
        Assert.assertEquals(loginCase.getExpected(), result);
    }

    @Test(groups = "loginFailed", description = "用户登录失败接口测试")
    public void login_Failed() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        //取id为2的登录接口测试数据
        com.course.model.LoginCase loginCase = sqlSession.selectOne("loginCase", 2);
        System.out.println(loginCase);
        System.out.println(TestConfig.loginUrl);

        //发请求，获取结果
        String result = getResult(loginCase);

        //验证返回结果
        Assert.assertEquals(loginCase.getExpected(), result);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        //post请求
        HttpPost post = new HttpPost(TestConfig.loginUrl);

        //请求头信息
        post.setHeader("Content-type", "application/json");

        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("userName", loginCase.getUserName());
        param.put("password", loginCase.getPassword());
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //发送请求，获取结果
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //保存cookies
        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();

        return result;
    }

}
