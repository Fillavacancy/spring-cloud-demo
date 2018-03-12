package com.example.spingcloudeurekaserverprovider2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SpingCloudEurekaServerProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudEurekaServerProvider2Application.class, args);
    }

    @RequestMapping("/hi")
    public String home() {
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        return restTemplate.getForObject("http://sping-cloud-eureka-server-provider-1:2100/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    //开启软均衡负载
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
