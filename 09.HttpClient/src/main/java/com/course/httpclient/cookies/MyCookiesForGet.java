package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
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
 * @create 2022-03-29 16:54
 */
public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    //用来保存cookies
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
    public void testGetWithCookies() throws IOException {
        //从配置文件中获取URL
        String uri = bundle.getString("getWithCookies.uri");
        String fullUrl = this.url + uri;
        String result;
        HttpGet httpGet = new HttpGet(fullUrl);
        DefaultHttpClient httpClient = new DefaultHttpClient();

        //设置cookies
        httpClient.setCookieStore(this.store);


        //执行get请求
        HttpResponse response = httpClient.execute(httpGet);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200);

        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

    }


}
