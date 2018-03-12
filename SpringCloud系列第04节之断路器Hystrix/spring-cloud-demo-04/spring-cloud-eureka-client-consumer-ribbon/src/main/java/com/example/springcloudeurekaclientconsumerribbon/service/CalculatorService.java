package com.example.springcloudeurekaclientconsumerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculatorService {

    @Autowired
    private RestTemplate restTemplate;


    //指定断路后的回调方法（回调方法必须与原方法参数类型相同、返回值类型相同、方法名可以不同）
    @HystrixCommand(fallbackMethod = "addServiceToFallback")
    public int addService(int a, int b) {
        String reqURL = "http://sping-cloud-eureka-server-provider/add?a=" + a + "&b=" + b;
        return restTemplate.getForEntity(reqURL, Integer.class).getBody();
    }

    public int addServiceToFallback(int aa, int bb) {
        return -999;
    }
}