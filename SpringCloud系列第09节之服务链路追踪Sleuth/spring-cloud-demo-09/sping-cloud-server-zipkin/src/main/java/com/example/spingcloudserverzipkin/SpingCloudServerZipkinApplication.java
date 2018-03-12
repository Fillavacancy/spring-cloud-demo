package com.example.spingcloudserverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

//开启ZipkinServer的功能
@EnableZipkinServer
@SpringBootApplication
public class SpingCloudServerZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudServerZipkinApplication.class, args);
    }
}
