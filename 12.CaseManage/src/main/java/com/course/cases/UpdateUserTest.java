package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
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

        //执行请求获取结果
        int result = getResult(updateUserCase);

        //断言
        SqlSession sqlSession2 = DatabaseUtil.getSqlSession();
        User user = sqlSession2.selectOne(updateUserCase.getExpected(), updateUserCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    @Test(dependsOnGroups = "loginSuccess", description = "删除用户信息")
    public void deleteUser_Success() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserCase = sqlSession.selectOne("updateUserCase", 2);
        System.out.println(updateUserCase);
        System.out.println(TestConfig.updateUserInfoUrl);

        //执行请求获取结果
        int result = getResult(updateUserCase);

        //断言
        SqlSession sqlSession2 = DatabaseUtil.getSqlSession();
        User user = sqlSession2.selectOne(updateUserCase.getExpected(), updateUserCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }


    private int getResult(UpdateUserInfoCase updateUserCase) throws IOException {
        //post请求
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);

        //请求头
        post.setHeader("Content-type", "application/json");

        //Cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //请求参数
        JSONObject param = new JSONObject();
        param.put("id", updateUserCase.getUserId());
        param.put("userName", updateUserCase.getUserName());
        param.put("sex", updateUserCase.getSex());
        param.put("age", updateUserCase.getAge());
        param.put("permission", updateUserCase.getPermission());
        param.put("isDelete", updateUserCase.getIsDelete());
        StringEntity entity= new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //执行请求
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        System.out.println(response);
        int result=Integer.parseInt(EntityUtils.toString(response.getEntity(),"utf-8"));

        return result;
    }

}
