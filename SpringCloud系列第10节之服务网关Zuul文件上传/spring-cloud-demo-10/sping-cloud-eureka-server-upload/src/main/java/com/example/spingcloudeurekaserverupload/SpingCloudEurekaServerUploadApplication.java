package com.example.spingcloudeurekaserverupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@EnableHystrixDashboard // Hystrix 仪表盘
@SpringBootApplication
public class SpingCloudEurekaServerUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudEurekaServerUploadApplication.class, args);
    }
}
