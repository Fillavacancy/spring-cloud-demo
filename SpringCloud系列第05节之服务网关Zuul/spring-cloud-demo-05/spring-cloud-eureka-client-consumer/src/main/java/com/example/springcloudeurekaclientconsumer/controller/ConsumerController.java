package com.example.springcloudeurekaclientconsumer.controller;

import com.example.springcloudeurekaclientconsumer.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务调用方
 */
@RestController
@RequestMapping("/demo/feign")
public class ConsumerController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/toadd")
    public String toadd(int a, int b, String accesstoken) {
        return calculatorService.myadd(a, b, accesstoken);
    }
}