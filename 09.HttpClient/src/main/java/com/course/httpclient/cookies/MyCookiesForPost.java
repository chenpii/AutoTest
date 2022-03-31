package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author chenpi
 * @create 2022-03-31 11:03
 */
public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        //从配置文件中获取URL
        String uri = bundle.getString("getCookies.uri");
        String fullUrl = this.url + uri;
        String result;
        HttpGet httpGet = new HttpGet(fullUrl);
        DefaultHttpClient httpClient = new DefaultHttpClient();

        //执行get请求
        HttpResponse response = httpClient.execute(httpGet);
        result = EntityUtils.toString(response.getEntity());

        //获取Cookies
        this.store = httpClient.getCookieStore();
        List<Cookie> cookies = store.getCookies();
        for (Cookie c : cookies) {
            String name = c.getName();
            String value = c.getValue();
            System.out.println("cookie : name=" + name + ",value=" + value);
        }

        //断言包含某值
        Assert.assertTrue(result.contains("成功"));

    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testPostWithCookies() throws IOException {
        //从配置文件中获取URL
        String uri = bundle.getString("postWithCookies.uri");
        String fullUrl = this.url + uri;
        String result;
        HttpPost post = new HttpPost(fullUrl);
        DefaultHttpClient httpClient = new DefaultHttpClient();

        //设置请求头信息 设置header
        post.setHeader("content-type", "application/json");

        //设置json参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //设置cookies信息
        httpClient.setCookieStore(this.store);
        //执行post请求
        HttpResponse response = httpClient.execute(post);
        //断言状态
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        //获取结果
        result = EntityUtils.toString(response.getEntity());
        //将返回的响应结果字符串转化成Json
        JSONObject jsonResult = JSONObject.parseObject(result);
        //断言json字段
        Assert.assertEquals(jsonResult.getString("huhansan"), "success");
        Assert.assertEquals(jsonResult.getInteger("status"), 1);

    }

}
