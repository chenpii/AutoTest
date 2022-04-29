package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

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

        //发送请求获取结果
        JSONArray resultJson = getJsonResult(getUserInfoCase);
        //断言结果
        //数据获取实际结果
        List<User> userList = sqlSession.selectList(getUserInfoCase.getExpected(), getUserInfoCase);
        for (User u : userList) {
            System.out.println("获取到的用户信息：" + u.toString());
        }
        JSONArray userListArray = new JSONArray(userList);
        //断言长度
        Assert.assertEquals(resultJson.length(), userListArray.length());
    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        //post请求
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);

        //设置请求头
        post.setHeader("Context-type", "application/json");

        //设置cookis
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //请求参数
        JSONObject param = new JSONObject();
        param.put("id", getUserInfoCase.getUserId());
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //执行请求
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity());

        //转成json
        JSONArray jsonResult = new JSONArray(result);

        return jsonResult;
    }
}
