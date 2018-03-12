package com.example.spingcloudeurekaserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//创建服务注册中心
@EnableEurekaServer
@SpringBootApplication
public class SpingCloudEurekaServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudEurekaServer2Application.class, args);
    }
}
