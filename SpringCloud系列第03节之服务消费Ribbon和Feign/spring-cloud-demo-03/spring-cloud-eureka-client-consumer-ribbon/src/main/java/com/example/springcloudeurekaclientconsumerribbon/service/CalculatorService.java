package com.example.springcloudeurekaclientconsumerribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CalculatorService {

    @Autowired
    private RestTemplate restTemplate;

    public int addService(int a, int b) {
        String reqURL = "http://sping-cloud-eureka-server-provider-1/add?a=" + a + "&b=" + b;
        return restTemplate.getForEntity(reqURL, Integer.class).getBody();
    }
}