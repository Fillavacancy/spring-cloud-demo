package com.example.springcloudeurekaclientconsumerfeign.controller;

import com.example.springcloudeurekaclientconsumerfeign.service.CalculatorService;
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
    public int toadd(int a, int b) {
        return calculatorService.myadd(a, b);
    }
}