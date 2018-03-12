package com.example.springcloudeurekaclientconsumerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.Charset;

@Service
public class CalculatorService {

    // 设置要进行远程上传微服务调用的代理地址
    public static final String UPLOAD_URL = "http://localhost:3100/zuul/upload-proxy/upload";

    //指定断路后的回调方法（回调方法必须与原方法参数类型相同、返回值类型相同、方法名可以不同）
    @HystrixCommand(fallbackMethod = "uploadServiceToFallback")
    public String uploadService(String name, MultipartFile photo) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建一个HttpClient对象
        HttpClientContext httpContext = HttpClientContext.create(); // 创建Http处理操作的上下文对象
        HttpPost httpPost = new HttpPost(UPLOAD_URL); // 设置要进行访问的请求地址
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("photo", photo.getBytes(),
                        ContentType.create("image/jpeg"), "temp.jpg")
                .build();
        httpPost.setEntity(entity);    // 将请求的实体信息进行发送
        HttpResponse response = httpClient.execute(httpPost, httpContext);    // 执行请求的发送
        return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
    }

    public String uploadServiceToFallback(String name, MultipartFile photo) {
        return "nophoto.jpg";
    }
}