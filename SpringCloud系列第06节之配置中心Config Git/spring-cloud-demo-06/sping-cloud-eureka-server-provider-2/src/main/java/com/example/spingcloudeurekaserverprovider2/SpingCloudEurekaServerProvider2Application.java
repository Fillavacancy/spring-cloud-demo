package com.example.spingcloudeurekaserverprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpingCloudEurekaServerProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudEurekaServerProvider2Application.class, args);
    }
}
