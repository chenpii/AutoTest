package com.chenpi.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

/**
 * @author chenpi
 * @create 2022-03-24 14:52
 */
public class MyHttpClient {

    @Test
    public void test1() throws IOException {

        //存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //声明HttpClient对象，用来进行方法的执行
        HttpClient client = new DefaultHttpClient();
        HttpResponse execute = client.execute(get);

        result = EntityUtils.toString(execute.getEntity(),"UTF-8");
        System.out.println(result);
    }
}
