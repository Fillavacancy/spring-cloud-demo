package com.example.springcloudeurekaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//为服务提供方赋予注册和发现服务的能力
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudEurekaClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient1Application.class, args);
    }
}
