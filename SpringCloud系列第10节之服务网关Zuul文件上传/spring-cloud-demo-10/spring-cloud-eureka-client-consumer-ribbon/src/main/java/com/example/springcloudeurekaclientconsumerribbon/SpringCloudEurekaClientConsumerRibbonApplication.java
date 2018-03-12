package com.example.springcloudeurekaclientconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//开启断路器功能
@EnableCircuitBreaker
@EnableEurekaClient
@EnableHystrixDashboard // Hystrix 仪表盘
@SpringBootApplication
public class SpringCloudEurekaClientConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClientConsumerRibbonApplication.class, args);
    }
}
