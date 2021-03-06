package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author chenpi
 * @create 2022-03-31 10:01
 */
public class MyJsonForGet {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetJson() throws IOException {
        //从配置文件中获取URL
        String uri = bundle.getString("getJson.uri");
        String fullUrl = this.url + uri;
        String result;

        HttpGet httpGet = new HttpGet(fullUrl);
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
        result = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSON.parseObject(result);
        //断言Json字段值相等
        Assert.assertEquals(jsonObject.getString("code"), "1181000");
        Assert.assertEquals(jsonObject.getString("message"), "成功");

    }
}
