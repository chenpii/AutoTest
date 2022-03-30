package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author chenpi
 * @create 2022-03-29 16:54
 */
public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");

    }

    @Test
    public void test() throws IOException {
        //从配置文件中获取URL
        String uri = bundle.getString("getCookies.uri");
        String fullUrl = url + uri;
        String result;

        HttpGet httpGet = new HttpGet(fullUrl);
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
        result = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSON.parseObject(result);
        Assert.assertEquals(jsonObject.getString("huhansan"),"success");
        Assert.assertEquals(jsonObject.getInteger("status"),1);

    }


}
