package com.example.spingcloudeurekaserverprovider1;

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
public class SpingCloudEurekaServerProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpingCloudEurekaServerProvider1Application.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    //开启软均衡负载
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        return restTemplate.getForObject("http://sping-cloud-eureka-server-provider-2:2200/hi", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        System.out.println("i'm service-hi");
        return "i'm service-hi";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
