package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
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
import java.io.UnsupportedEncodingException;

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

        //发请求，获取结果
        String result = getResult(addUserCase);

        //验证返回结果
        User user = sqlSession.selectOne("addUser", addUserCase);
        System.out.println(user.toString());
        Assert.assertEquals(addUserCase.getExpeceted(), result);

    }


    private String getResult(AddUserCase addUserCase) throws IOException {
        //post请求
        HttpPost post = new HttpPost(TestConfig.addUserUrl);

        //设置请求头信息
        post.setHeader("Content-type", "application/json");

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //设置请求参数
        JSONObject param = new JSONObject();
        param.put("userName", addUserCase.getUserName());
        param.put("password", addUserCase.getPassword());
        param.put("age", addUserCase.getAge());
        param.put("sex", addUserCase.getSex());
        param.put("permission", addUserCase.getPermission());
        param.put("isDelete", addUserCase.getIsDelete());

        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);

        //执行请求
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        return null;
    }
}
