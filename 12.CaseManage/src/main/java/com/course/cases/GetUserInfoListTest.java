package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoListCase;
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
 * @create 2022-04-10 18:09
 */
public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginSuccess", description = "获取性别为男的用户信息列表")
    public void getUserInfoListBySex() throws IOException {
        //获取id为1的getUserInfoListCase测试数据
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        GetUserInfoListCase getUserInfoListCase = sqlSession.selectOne("getUserInfoListCase", 1);
        System.out.println(getUserInfoListCase);
        System.out.println(TestConfig.getUserListUrl);

        //发送请求获取结果
        JSONArray resultJson = getJsonResult(getUserInfoListCase);

        //断言结果
        //从数据库查询到结果
        List<User> userList = sqlSession.selectList(getUserInfoListCase.getExpected(), getUserInfoListCase);
        for (User u : userList) {
            System.out.println("获取到的用户信息：" + u.toString());
        }
        JSONArray userListArray = new JSONArray(userList);

        //断言两个的长度
        Assert.assertEquals(userListArray.length(), resultJson.length());

        //断言每个User
        for (int i = 0; i < userListArray.length(); i++) {

            JSONObject actual = (JSONObject) userListArray.get(i);
            JSONObject expect = (JSONObject) userListArray.get(i);
            Assert.assertEquals(actual.toString(), expect.toString());

        }

    }

    private JSONArray getJsonResult(GetUserInfoListCase getUserInfoListCase) throws IOException {
        //post请求
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);

        //设置请求头信息
        post.setHeader("Content-type", "application/json");

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("userName", getUserInfoListCase.getUserName());
        param.put("age", getUserInfoListCase.getAge());
        param.put("sex", getUserInfoListCase.getSex());
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //执行请求获取结果
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(), "utf-8");

        //转换成json
        JSONArray jsonResutlt = new JSONArray(result);

        return jsonResutlt;
    }

}
